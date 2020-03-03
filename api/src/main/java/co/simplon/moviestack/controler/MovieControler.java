/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.controler;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.service.MovieService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franck
 */
@RestController
@RequestMapping("/api/movies")
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
     * Create a movie
     *
     * @param newMovie
     * @return
     */
    @PostMapping
    public Movie createAliment(@RequestBody @Valid Movie newMovie) {
        return movieService.createMovie(newMovie);
    }

    /**
     * Update a movie
     *
     * @param updMovie
     * @return
     */
    @PostMapping
    public Movie updateMovie(@RequestBody @Valid Movie updMovie) {
        return movieService.updateMovie(updMovie);
    }
}
