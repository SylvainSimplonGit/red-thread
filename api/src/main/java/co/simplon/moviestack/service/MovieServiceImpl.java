package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Genre;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.repository.ActorRepository;
import co.simplon.moviestack.repository.GenreRepository;
import co.simplon.moviestack.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
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
    public Movie getMovieFromTMDBByImdbID(String imdbId) throws JsonProcessingException {

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

        Movie newMovie = new Movie(imdbId, jsonMovie.get("title").asText());
        newMovie.setRuntime(jsonMovie.get("runtime").asInt());
        newMovie.setReleased(jsonMovie.get("release_date").asText());
        newMovie.setPlot(jsonMovie.get("overview").asText());

        List<Genre> genres = new ArrayList<>();

        for (Object genreObj : jsonMovie.get("genres")) {
            ObjectMapper mapperGenre = new ObjectMapper();
            JsonNode jsonGenre = mapperGenre.readTree(genreObj.toString());
            Genre genre = new Genre(jsonGenre.get("id").asLong(), jsonGenre.get("name").asText());
            genres.add(genre);
            this.genreRepository.save(genre);
        }

        newMovie.setActors(this.getActorFromTMDBByImdbID(imdbId));
        newMovie.setGenres(genres);

        movieRepository.save(newMovie);

        System.out.println("Ajout du film (" + newMovie.getIdImdb() + ") : " + newMovie.getTitle());

        return newMovie;
    }

    @Override
    public List<Actor> getActorFromTMDBByImdbID(String imdbId) throws JsonProcessingException {
        Map<String, String> args = new HashMap<>();
        args.put("Id", imdbId);
        args.put("key", "09f9524466812ccf78760c6ef7807fd5");
        args.put("lang", "fr-FR");

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
}
