package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Movie;
import java.util.List;

import co.simplon.moviestack.model.Opinion;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie createMovie(Movie newMovie);

    Movie updateMovie(Movie updateMovie);
    
    Movie getMovieById(String id);
    
    List<Movie> getMovies();

    Movie getMovieFromTMDBByImdbID(String imdbId) throws JsonProcessingException;

    List<Actor> getActorFromTMDBByImdbID(String imdbId) throws JsonProcessingException;

    String getDirectorFromTMDBByImdbID(String imdbId) throws JsonProcessingException;

    List<Opinion> getOpinionsByImdbID(String imdbId);

}
