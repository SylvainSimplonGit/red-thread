package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie createMovie(Movie newMovie);

    Movie updateMovie(Movie updateMovie);
}
