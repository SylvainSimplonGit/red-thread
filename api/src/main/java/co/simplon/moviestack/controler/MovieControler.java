/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.controler;

import co.simplon.moviestack.exception.InvalidMovieTMDBException;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.service.MovieService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author franck
 */
@RestController
@RequestMapping("/api/movies")
@CrossOrigin("*")
public class MovieControler {

    private MovieService movieService;

    /**
     * Constructor
     *
     * @param movieService
     */
    public MovieControler(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Get full movie
     *
     * @return
     */
    @GetMapping()
    public Object getMovies() {
        try {
            return movieService.getMovies();
        } catch (EntityNotFoundException e) {
            return e.getMessage();
        }
    }

    /**
     * Get movie with movieId
     *
     * @param movieId
     * @return
     */
    @GetMapping("/{movieId}")
    public Object getMovieById(@PathVariable String movieId) {
        try {
            return movieService.getMovieById(movieId);
        } catch (EntityNotFoundException e) {
            return e.getMessage();
        }
    }

    /**
     * Get movie from TheMovieDB with IMDB Id
     *
     * @param movieId
     * @return
     */
    @GetMapping("/{movieId}/tmdb")
    public Object getMovieFromTmdbByImdbId(@PathVariable String movieId) {
        try {
            return movieService.getMovieFromTMDBByImdbID(Integer.parseInt(movieId), true);
        } catch (NumberFormatException e) {
            try {
                return movieService.getMovieFromTMDBByImdbID(movieId, true);
            } catch (InvalidMovieTMDBException | JsonProcessingException i) {
                return i.getMessage();
            }
        } catch (InvalidMovieTMDBException | JsonProcessingException i) {
            return i.getMessage();
        }
    }

    /**
     * Get movie from TheMovieDB with IMDB Id
     *
     * @param movieId
     * @return
     */
    @GetMapping("/{movieId}/opinions")
    public List<Opinion> getOpinionsByImdbId(@PathVariable String movieId) {
        return movieService.getOpinionsByImdbID(movieId);
    }

    /**
     * Search movie from TheMovieDB with keyword
     *
     * @param keyword
     * @return
     */
    @GetMapping("/search/{keyword}")
    public List<Movie> searchMoviesFromTMDBByKeyword(@PathVariable String keyword) throws JsonProcessingException, InvalidMovieTMDBException {
        return movieService.searchMoviesFromTMDBByKeyword(keyword);
    }

    /**
     * Create a movie
     *
     * @param newMovie
     * @return
     */
    @PostMapping()
    public Movie createMovie(@RequestBody @Valid Movie newMovie) {
        return movieService.createMovie(newMovie);
    }

    /**
     * Update a movie
     *
     * @param updMovie
     * @return
     */
    @PutMapping()
    public Movie updateMovie(@RequestBody @Valid Movie updMovie) {
        return movieService.updateMovie(updMovie);
    }
}
