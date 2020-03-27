package co.simplon.moviestack.service;

import co.simplon.moviestack.exception.InvalidMovieTMDBException;
import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Genre;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.repository.ActorRepository;
import co.simplon.moviestack.repository.GenreRepository;
import co.simplon.moviestack.repository.MovieRepository;
import co.simplon.moviestack.repository.OpinionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.net.ConnectException;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
    static final String ERROR_PARSE = "{} | Erreur de Parsing JSON : {}";
    static final String ERROR_ACCESS = "{} | Erreur d'accès' : {}";
    static final String ERROR_TIMEOUT = "Timeout of TMDB !";
    static final String ERROR_HTTP = "{} | Erreur de requête : {}";
    static final String ERROR_FORMAT = "{} | Erreur Format : {}";
    static final String ERROR_OTHER = "{} | Erreur : {}";

    static final String TMDB_FIELD_ID = "id";
    static final String TMDB_FIELD_IDIMDB = "imdb_id";
    static final String TMDB_FIELD_TITLE = "title";
    static final String TMDB_FIELD_RUNTIME = "runtime";
    static final String TMDB_FIELD_DATE = "release_date";
    static final String TMDB_FIELD_OVERVIEW = "overview";
    static final String TMDB_FIELD_NAME = "name";
    static final String TMDB_FIELD_PATH = "file_path";
    static final String TMDB_FIELD_RESULTS = "results";
    static final String TMDB_FIELD_RATIO = "aspect_ratio";
    static final String TMDB_FIELD_POSTER = "posters";
    static final String TMDB_FIELD_GENRES = "genres";
    static final String TMDB_FIELD_CAST = "cast";

    static final String OMDB_FIELD_VOTES = "imdbVotes";
    static final String OMDB_FIELD_RATE = "imdbRating";


    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private GenreRepository genreRepository;
    private OpinionRepository opinionRepository;

    private RestTemplate restTemplate;

    private Map<String, String> args = new HashMap<>();
    private Map<String, String> argsOmdb = new HashMap<>();

    public MovieServiceImpl(
            MovieRepository movieRepository,
            ActorRepository actorRepository,
            GenreRepository genreRepository,
            OpinionRepository opinionRepository,
            RestTemplateBuilder restTemplateBuilder
    ) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.genreRepository = genreRepository;
        this.opinionRepository = opinionRepository;
        this.restTemplate = restTemplateBuilder.build();

        this.args.put("key", "09f9524466812ccf78760c6ef7807fd5");
        this.args.put("lang", "fr-FR");

        this.argsOmdb.put("key", "3c7d9cd");
    }

    public static String methodName() { return Thread.currentThread().getStackTrace()[2].getMethodName(); }

    @Override
    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie updateMovie(Movie updateMovie) {
        return movieRepository.save(updateMovie);
    }

    @Override
    public Movie getMovieById(String id) {
        Optional<Movie> dbMovie = movieRepository.findById(id);
        if (dbMovie.isPresent()) {
            return dbMovie.get();
        } else {
            throw new EntityNotFoundException("The movie with ID: " + id + " cannot be found in DB Movie");
        }
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> dbMovies = movieRepository.findAll();
        if (!dbMovies.isEmpty()) {
            return dbMovies;
        } else {
            throw new EntityNotFoundException("No movie in DB Movie");
        }
    }

    @Override
    public Movie getMovieFromTMDBByImdbID (String imdbId, boolean save) throws InvalidMovieTMDBException {
        return this.getMovieFormTMDB(imdbId, save);
    }

    @Override
    public Movie getMovieFromTMDBByImdbID (Integer tmdbId, boolean save) throws InvalidMovieTMDBException {
        String imdbId = tmdbId.toString();
        return this.getMovieFormTMDB(imdbId, save);
    }

    @Override
    public List<Actor> getActorsFromTMDBByImdbID (String imdbId) throws InvalidMovieTMDBException {
        this.args.put("Id", imdbId);

        List<Actor> actors = new ArrayList<>();

        try {
            String movieImdb =  this.restTemplate.getForObject(
                    "https://api.themoviedb.org/3/movie/{Id}/credits?api_key={key}",
                    String.class,
                    this.args
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);
                actors = this.addActors(jsonMovie);
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }
        return actors;
    }

    @Override
    public String getDirectorFromTMDBByImdbID (String imdbId) throws InvalidMovieTMDBException {
        this.args.put("Id", imdbId);

        try {
            String movieImdb =  this.restTemplate.getForObject(
                    "https://api.themoviedb.org/3/movie/{Id}/credits?api_key={key}",
                    String.class,
                    this.args
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                for (Object crew : jsonMovie.get("crew")) {
                    ObjectMapper mapperCrew = new ObjectMapper();
                    JsonNode jsonCrew = mapperCrew.readTree(crew.toString());

                    if (
                            jsonCrew.has("job") &&
                                    jsonCrew.get("job").asText().equals("Director")
                    ) {
                        String nameDirector = jsonCrew.get(TMDB_FIELD_NAME).asText();
                        LOGGER.info("Ajout du réalisateur ({})", nameDirector);
                        return nameDirector;
                    }
                }
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return null;
    }

    @Override
    public Float getImdbRatingFromOMDBByImdbID(String imdbId) throws InvalidMovieTMDBException {
        argsOmdb.put("Id", imdbId);

        try {
            String movieImdb =  this.restTemplate.getForObject(
                    "http://www.omdbapi.com/?i={Id}&apikey={key}",
                    String.class,
                    this.argsOmdb
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                if (
                        jsonMovie.has(OMDB_FIELD_RATE) &&
                        !jsonMovie.get(OMDB_FIELD_RATE).asText().equals("N/A")
                ) {
                    return Float.parseFloat(jsonMovie.get(OMDB_FIELD_RATE).asText());
                }
            }

        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return null;
    }

    @Override
    public Integer getImdbVotesFromOMDBByImdbID(String imdbId) throws InvalidMovieTMDBException {
        argsOmdb.put("Id", imdbId);

        try {
            String movieImdb =  this.restTemplate.getForObject(
                    "http://www.omdbapi.com/?i={Id}&apikey={key}",
                    String.class,
                    this.argsOmdb
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                if (
                        jsonMovie.has(OMDB_FIELD_VOTES) &&
                        !jsonMovie.get(OMDB_FIELD_VOTES).asText().equals("N/A")
                ) {
                    return Integer.parseInt(jsonMovie.get(OMDB_FIELD_VOTES).asText().replace(",", ""));
                }
            }

        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return null;
    }  
  
    @Override
    public String getPosterFromTMDBByImdbID(String imdbId) throws InvalidMovieTMDBException {

        this.args.put("Id", imdbId);

        try {
            String movieImdb =  this.restTemplate.getForObject(
                    "https://api.themoviedb.org/3/movie/{Id}/images?api_key={key}",
                    String.class,
                    this.args
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                if (jsonMovie.has(TMDB_FIELD_POSTER)) {
                    return this.searchPosterWithRatio(jsonMovie);
                }
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return null;
    }
    
    @Override
    public List<Opinion> getOpinionsByImdbID(String imdbId) {
        return movieRepository.getListOfOpinionsByMovie(imdbId);
//        return opinionRepository.getListOfOpinionsByMovie(imdbId);
    }

    @Override
    public List<Movie> searchMoviesFromTMDBByKeyword(String keyword) throws InvalidMovieTMDBException {
        this.args.put("keyword", keyword);

        List<Movie> moviesSearch = new ArrayList<>();
        int maxSearch = 5;

        try {
            String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/search/movie?query={keyword}&language={lang}&api_key={key}",
                String.class,
                this.args
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                if (this.checkNode(jsonMovie, TMDB_FIELD_RESULTS)) {
                    for (Object returns : jsonMovie.get(TMDB_FIELD_RESULTS)) {
                        if (maxSearch <= 0) {
                            break;
                        }
                        ObjectMapper mapperReturns = new ObjectMapper();
                        JsonNode jsonMovieSearch = mapperReturns.readTree(returns.toString());

                        Movie movieSearch = this.getMovieFromTMDBByImdbID(jsonMovieSearch.get(TMDB_FIELD_ID).asInt(), false);
                        if (moviesSearch != null && movieSearch.getTitle() != null) {
                            moviesSearch.add(movieSearch);
                            --maxSearch;
                        }

                    }
                }
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return moviesSearch;
    }

    private Movie getMovieFormTMDB(String imdbId, boolean save) throws InvalidMovieTMDBException {
        this.args.put("Id", imdbId);

        try {
            String movieImdb = this.restTemplate.getForObject(
                    "https://api.themoviedb.org/3/movie/{Id}?api_key={key}&language={lang}",
                    String.class,
                    this.args
            );

            if (movieImdb != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonMovie = mapper.readTree(movieImdb);

                if (checkIdAndTitle(jsonMovie)) {
                    Movie newMovie = new Movie(jsonMovie.get(TMDB_FIELD_IDIMDB).asText(), jsonMovie.get(TMDB_FIELD_TITLE).asText());

                    this.addRuntime(jsonMovie, newMovie);
                    this.addReleased(jsonMovie, newMovie);
                    this.addPlot(jsonMovie, newMovie);
                    newMovie.setGenres(this.addGenres(jsonMovie));
                    newMovie.setPosterUrl(this.getPosterFromTMDBByImdbID(imdbId));
                    newMovie.setActors(this.getActorsFromTMDBByImdbID(imdbId));
                    newMovie.setDirector(this.getDirectorFromTMDBByImdbID(imdbId));
                    newMovie.setImdbRating(this.getImdbRatingFromOMDBByImdbID(imdbId));
                    newMovie.setImdbVote(this.getImdbVotesFromOMDBByImdbID(imdbId));

                    if (save) {
                        movieRepository.save(newMovie);
                    }

                    LOGGER.info("Ajout du film ({}) : {}", newMovie.getIdImdb(), newMovie.getTitle());

                    return newMovie;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }
        return null;
    }

    private void errorManagement(Exception e, String method) throws InvalidMovieTMDBException {
        if (e instanceof ResourceAccessException) {
            if (e.getCause() instanceof ConnectException) {
                LOGGER.error(ERROR_ACCESS, method, ERROR_TIMEOUT);
            } else {
                LOGGER.error(ERROR_ACCESS, method, e.getMessage());
            }
        }
        else if (e instanceof JsonProcessingException) {
            LOGGER.error(ERROR_PARSE, method, e.getMessage());
        }
        else if (e instanceof HttpClientErrorException) {
            LOGGER.error(ERROR_HTTP, method, e.getMessage());
            if (e.getMessage().contains("404")) {
                throw new InvalidMovieTMDBException("The resource you requested could not be found.");
            }
        }
        else if (e instanceof NumberFormatException) {
            LOGGER.error(ERROR_FORMAT, method, e.getMessage());
        }
        else {
            LOGGER.error(ERROR_OTHER, method, e.getMessage());
        }
    }

    private boolean checkNode (JsonNode jsonNode, String nodeText) {
        return (
                jsonNode.has(nodeText) &&
                        !jsonNode.get(nodeText).isNull() &&
                        (
                                !jsonNode.get(nodeText).asText().equals("") ||
                                        jsonNode.get(nodeText).size() > 0
                        )
        );
    }

    private boolean checkIdAndTitle (JsonNode jsonNode) {
        return (checkNode(jsonNode, TMDB_FIELD_IDIMDB) && checkNode(jsonNode, TMDB_FIELD_TITLE));
    }

    private void addRuntime (JsonNode jsonNode, Movie movie) {
        if (checkNode(jsonNode, TMDB_FIELD_RUNTIME)) {
            String runtime = jsonNode.get(TMDB_FIELD_RUNTIME).asText();
            movie.setRuntime(jsonNode.get(TMDB_FIELD_RUNTIME).asInt());
            LOGGER.info("Ajout de la Durée : {}", runtime);
        }
    }

    private void addReleased (JsonNode jsonNode, Movie movie) {
        if (checkNode(jsonNode, TMDB_FIELD_DATE)) {
            String releaseDate = jsonNode.get(TMDB_FIELD_DATE).asText();
            movie.setReleased(releaseDate);
            LOGGER.info("Ajout de la Date de sortie : {}", releaseDate);
        }
    }

    private void addPlot (JsonNode jsonNode, Movie movie) {
        if (checkNode(jsonNode, TMDB_FIELD_OVERVIEW)) {
            movie.setPlot(jsonNode.get(TMDB_FIELD_OVERVIEW).asText());
            String msg;
            if (jsonNode.get(TMDB_FIELD_OVERVIEW).asText().length() >= 40) {
                msg = jsonNode.get(TMDB_FIELD_OVERVIEW).asText().substring(0, 40) + " ...";
            } else {
                msg = jsonNode.get(TMDB_FIELD_OVERVIEW).asText();
            }
            LOGGER.info("Ajout du Synopsis : {}", msg);
        }
    }

    private List<Genre> addGenres (JsonNode jsonNode) throws InvalidMovieTMDBException {
        List<Genre> genres = new ArrayList<>();

        if (checkNode(jsonNode, TMDB_FIELD_GENRES)) {

            for (Object genreObj : jsonNode.get(TMDB_FIELD_GENRES)) {
                try {
                    ObjectMapper mapperGenre = new ObjectMapper();
                    JsonNode jsonGenre = mapperGenre.readTree(genreObj.toString());
                    Genre genre = new Genre(jsonGenre.get(TMDB_FIELD_ID).asLong(), jsonGenre.get(TMDB_FIELD_NAME).asText());
                    genres.add(genre);
                    LOGGER.info("Ajout du genre ({}) : {}", genre.getIdGenre(), genre.getName());
                    this.genreRepository.save(genre);
                } catch (Exception e) {
                    this.errorManagement(e, methodName());
                }
            }
        } else {
            LOGGER.info("Ajout d'aucun genre !");
        }
        return genres;
    }

    private List<Actor> addActors (JsonNode jsonNode) throws InvalidMovieTMDBException {
        List<Actor> actors = new ArrayList<>();

        if (checkNode(jsonNode, TMDB_FIELD_CAST)) {
            for (Object cast : jsonNode.get(TMDB_FIELD_CAST)) {
                try {
                    ObjectMapper mapperCast = new ObjectMapper();
                    JsonNode jsonActor = mapperCast.readTree(cast.toString());
                    Actor actor = new Actor(jsonActor.get(TMDB_FIELD_ID).asLong(), jsonActor.get(TMDB_FIELD_NAME).asText());
                    actorRepository.save(actor);
                    actors.add(actor);
                    LOGGER.info("Ajout de l'acteur ({}) : {}", actor.getIdActor(), actor.getName());
                } catch (Exception e) {
                    this.errorManagement(e, methodName());
                }
            }
        }
        return actors;
    }

    private String searchPosterWithRatio(JsonNode jsonNode) throws InvalidMovieTMDBException {
        String urlImage = "http://image.tmdb.org/t/p/original";

        try {
            for (Object poster : jsonNode.get(TMDB_FIELD_POSTER)) {
                ObjectMapper mapperPoster = new ObjectMapper();
                JsonNode jsonPoster = mapperPoster.readTree(poster.toString());
                if ( jsonPoster.has(TMDB_FIELD_RATIO) &&
                        jsonPoster.has(TMDB_FIELD_PATH) &&
                        jsonPoster.get(TMDB_FIELD_RATIO).asDouble() == 0.6666666666666666
                ) {
                    String msg = urlImage + jsonPoster.get(TMDB_FIELD_PATH).asText();
                    LOGGER.info("Ajout du Poster : {}", msg);
                    return urlImage + jsonPoster.get(TMDB_FIELD_PATH).asText();
                }
            }
        } catch (Exception e) {
            this.errorManagement(e, methodName());
        }

        return null;
    }

}
