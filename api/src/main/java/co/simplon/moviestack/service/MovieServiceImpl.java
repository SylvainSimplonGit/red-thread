package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Genre;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.repository.ActorRepository;
import co.simplon.moviestack.repository.GenreRepository;
import co.simplon.moviestack.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import javax.persistence.EntityNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private GenreRepository genreRepository;

    private final RestTemplate restTemplate;

    public MovieServiceImpl(
            MovieRepository movieRepository,
            ActorRepository actorRepository,
            GenreRepository genreRepository,
            RestTemplateBuilder restTemplateBuilder
    ) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.genreRepository = genreRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie updateMovie(Movie updateMovie) {
        return movieRepository.save(updateMovie);
    }

    @Override
    public Movie getMovieById(String id) throws EntityNotFoundException {
        Optional<Movie> dbMovie = movieRepository.findById(id);
        if(dbMovie.isPresent()){
            return dbMovie.get();
        } else {
            throw new EntityNotFoundException("The movie with ID: " + id + " cannot be found in DB Movie");
        }
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieFromTMDBByImdbID(String imdbId, Boolean save) throws JsonProcessingException {

        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");
        args.put("lang", "fr-FR");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/{Id}?api_key={key}&language={lang}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        if (
                jsonMovie.has("imdb_id") && !jsonMovie.get("imdb_id").isNull() && !jsonMovie.get("imdb_id").asText().equals("") &&
                jsonMovie.has("title") && !jsonMovie.get("title").isNull() && !jsonMovie.get("title").asText().equals("")
        ) {
            Movie newMovie = new Movie(imdbId, jsonMovie.get("title").asText());

            if (jsonMovie.has("runtime")) { newMovie.setRuntime(jsonMovie.get("runtime").asInt()); }
            if (jsonMovie.has("released_date")) { newMovie.setReleased(jsonMovie.get("release_date").asText()); }
            if (jsonMovie.has("overview")) { newMovie.setPlot(jsonMovie.get("overview").asText()); }

            if (jsonMovie.has("genres")) {
                List<Genre> genres = new ArrayList<>();

                for (Object genreObj : jsonMovie.get("genres")) {
                    ObjectMapper mapperGenre = new ObjectMapper();
                    JsonNode jsonGenre = mapperGenre.readTree(genreObj.toString());
                    Genre genre = new Genre(jsonGenre.get("id").asLong(), jsonGenre.get("name").asText());
                    genres.add(genre);
                    this.genreRepository.save(genre);
                }

                newMovie.setGenres(genres);
            }

            newMovie.setPosterUrl(this.getPosterFromTMDBByImdbID(imdbId));
            newMovie.setActors(this.getActorsFromTMDBByImdbID(imdbId));
            newMovie.setDirector(this.getDirectorFromTMDBByImdbID(imdbId));

            newMovie.setImdbRating(this.getImdbRatingFromOMDBByImdbID(imdbId));
            newMovie.setImdbVote(this.getImdbVotesFromOMDBByImdbID(imdbId));

            if (save) { movieRepository.save(newMovie); }

            System.out.println("Ajout du film (" + newMovie.getIdImdb() + ") : " + newMovie.getTitle());

            return newMovie;
        } else {
            return null;
        }

    }

    @Override
    public Movie getMovieFromTMDBByImdbID(Integer tmdbId, Boolean save) throws JsonProcessingException {

        Map<String, String> args = new HashMap<>();
        args.put("Id", tmdbId.toString());
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");
        args.put("lang", "fr-FR");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/{Id}?api_key={key}&language={lang}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        String imdbId = jsonMovie.get("imdb_id").asText();

        if (
                jsonMovie.has("imdb_id") && !jsonMovie.get("imdb_id").isNull() && !jsonMovie.get("imdb_id").asText().equals("") &&
                jsonMovie.has("title") && !jsonMovie.get("title").isNull() && !jsonMovie.get("title").asText().equals("")
        ) {
            Movie newMovie = new Movie(imdbId, jsonMovie.get("title").asText());

            if (jsonMovie.has("runtime")) { newMovie.setRuntime(jsonMovie.get("runtime").asInt()); }
            if (jsonMovie.has("released_date")) { newMovie.setReleased(jsonMovie.get("release_date").asText()); }
            if (jsonMovie.has("overview")) { newMovie.setPlot(jsonMovie.get("overview").asText()); }

            if (jsonMovie.has("genres")) {
                List<Genre> genres = new ArrayList<>();

                for (Object genreObj : jsonMovie.get("genres")) {
                    ObjectMapper mapperGenre = new ObjectMapper();
                    JsonNode jsonGenre = mapperGenre.readTree(genreObj.toString());
                    Genre genre = new Genre(jsonGenre.get("id").asLong(), jsonGenre.get("name").asText());
                    genres.add(genre);
                    this.genreRepository.save(genre);
                }

                newMovie.setGenres(genres);
            }

            newMovie.setPosterUrl(this.getPosterFromTMDBByImdbID(imdbId));
            newMovie.setActors(this.getActorsFromTMDBByImdbID(imdbId));
            newMovie.setDirector(this.getDirectorFromTMDBByImdbID(imdbId));

            newMovie.setImdbRating(this.getImdbRatingFromOMDBByImdbID(imdbId));
            newMovie.setImdbVote(this.getImdbVotesFromOMDBByImdbID(imdbId));

            if (save) { movieRepository.save(newMovie); }

            System.out.println("Ajout du film (" + newMovie.getIdImdb() + ") : " + newMovie.getTitle());

            return newMovie;
        } else {
            return null;
        }


    }

    @Override
    public List<Actor> getActorsFromTMDBByImdbID(String imdbId) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/{Id}/credits?api_key={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        List<Actor> actors = new ArrayList<>();

        for (Object cast : jsonMovie.get("cast")) {
            ObjectMapper mapperCast = new ObjectMapper();
            JsonNode jsonActor = mapperCast.readTree(cast.toString());

            Actor actor = new Actor(jsonActor.get("id").asLong(), jsonActor.get("name").asText());
            actorRepository.save(actor);
            actors.add(actor);
            System.out.println("Ajout de l'acteur (" + actor.getIdActor() + ") : " + actor.getName());
        }

        return actors;
    }

    @Override
    public String getDirectorFromTMDBByImdbID(String imdbId) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/{Id}/credits?api_key={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        for (Object crew : jsonMovie.get("crew")) {
            ObjectMapper mapperCrew = new ObjectMapper();
            JsonNode jsonCrew = mapperCrew.readTree(crew.toString());

            if (jsonCrew.has("job") && jsonCrew.get("job").asText().equals("Director")) {
                System.out.println("Ajout du réalisateur (" + jsonCrew.get("name").asText() + ")");
                return jsonCrew.get("name").asText();
            }
        }
        return null;
    }

    @Override
    public Float getImdbRatingFromOMDBByImdbID(String imdbId) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "3c7d9cd");

        String movieImdb =  this.restTemplate.getForObject(
                "http://www.omdbapi.com/?i={Id}&apikey={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        if (
                jsonMovie.has("imdbRating") &&
                !jsonMovie.get("imdbRating").asText().equals("N/A")
        ) {
            try {
                return Float.parseFloat(jsonMovie.get("imdbRating").asText());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Integer getImdbVotesFromOMDBByImdbID(String imdbId) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "3c7d9cd");

        String movieImdb =  this.restTemplate.getForObject(
                "http://www.omdbapi.com/?i={Id}&apikey={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        if (
                jsonMovie.has("imdbVotes") &&
                !jsonMovie.get("imdbVotes").asText().equals("N/A")
        ) {
            try {
                return Integer.parseInt(jsonMovie.get("imdbVotes").asText().replace(",", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return null;
    }  
  
    @Override
    public String getPosterFromTMDBByImdbID(String imdbId) throws JsonProcessingException {

        String urlImage = "http://image.tmdb.org/t/p/original";

        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/{Id}/images?api_key={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        if (jsonMovie.has("posters")) {
            ObjectMapper mapperPosters = new ObjectMapper();
            for (Object poster : jsonMovie.get("posters")) {
                ObjectMapper mapperPoster = new ObjectMapper();
                JsonNode jsonPoster = mapperPoster.readTree(poster.toString());
                if ( jsonPoster.has("aspect_ratio") &&
                     jsonPoster.has("file_path") &&
                     jsonPoster.get("aspect_ratio").asDouble() == 0.6666666666666666) {
                    System.out.println("Ajout du Poster : " + urlImage + jsonPoster.get("file_path").asText());
                    return urlImage + jsonPoster.get("file_path").asText();
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Opinion> getOpinionsByImdbID(String imdbId) {
        return movieRepository.getListOfOpinionsByMovie(imdbId);
    }

    @Override
    public List<Movie> searchMoviesFromTMDBByKeyword(String keyword) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("keyword", keyword);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");
        args.put("lang", "fr-FR");

        String movieImdb =  this.restTemplate.getForObject(
                "https://api.themoviedb.org/3/search/movie?query={keyword}&language={lang}&api_key={key}",
                String.class,
                args
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMovie = mapper.readTree(movieImdb);

        List<Movie> moviesSearch = new ArrayList<>();

        Integer maxSearch = 5;

        while (maxSearch > 0) {
            for (Object returns : jsonMovie.get("results")) {
                ObjectMapper mapperReturns = new ObjectMapper();
                JsonNode jsonMovieSearch = mapperReturns.readTree(returns.toString());

                Movie movieSearch = this.getMovieFromTMDBByImdbID(jsonMovieSearch.get("id").asInt(), false);
                if (moviesSearch != null) { moviesSearch.add(movieSearch); }
                maxSearch--;
            }
        }


//        {
//            "page": 1,
//                "total_results": 151,
//                "total_pages": 8,
//                "results": [
//                {
//                    "popularity": 36.605,
//                    "vote_count": 14281,
//                    "video": false,
//                    "poster_path": "/q8pF6s9b9veTQvxTqMDIQf9nJKi.jpg",
//                    "id": 10195,
//                    "adult": false,
//                    "backdrop_path": "/LvmmDZxkTDqp0DX7mUo621ahdX.jpg",
//                    "original_language": "en",
//                    "original_title": "Thor",
//                    "genre_ids": [
//                        28,
//                        12,
//                        14
//                    ],
//                    "title": "Thor",
//                    "vote_average": 6.7,
//                    "overview": "Thor, le héros du nouveau film issu de l'univers Marvel, est un guerrier tout-puissant et arrogant dont les actes téméraires font renaître de nos jours un conflit ancestral. À cause de cela, il est banni du Royaume mythique d’Asgard et est condamné à vivre parmi les humains. Mais lorsque les forces du Mal d’Asgard s’apprêtent à envahir la Terre, Thor découvre enfin ce que signifie \"être un héros\".",
//                    "release_date": "2011-04-21"
//                },

//        System.out.println(jsonMovie.toString());

        return moviesSearch;
    }
}
