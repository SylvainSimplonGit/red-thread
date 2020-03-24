package co.simplon.moviestack.service;

import co.simplon.moviestack.exception.InvalidMovieTMDBException;
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

    Movie getMovieFromTMDBByImdbID(String imdbId, boolean save) throws JsonProcessingException, InvalidMovieTMDBException;

    Movie getMovieFromTMDBByImdbID(Integer tmdbId, boolean save) throws JsonProcessingException, InvalidMovieTMDBException;

    List<Actor> getActorsFromTMDBByImdbID(String imdbId) throws JsonProcessingException, InvalidMovieTMDBException;

    String getDirectorFromTMDBByImdbID(String imdbId) throws JsonProcessingException, InvalidMovieTMDBException;

  	Float getImdbRatingFromOMDBByImdbID(String imdbId) throws JsonProcessingException, InvalidMovieTMDBException;

    Integer getImdbVotesFromOMDBByImdbID(String imdbId) throws JsonProcessingException, InvalidMovieTMDBException;

    String getPosterFromTMDBByImdbID(String imdbId) throws JsonProcessingException, InvalidMovieTMDBException;

    List<Opinion> getOpinionsByImdbID(String imdbId);

    List<Movie> searchMoviesFromTMDBByKeyword(String keyword) throws JsonProcessingException, InvalidMovieTMDBException;

}
