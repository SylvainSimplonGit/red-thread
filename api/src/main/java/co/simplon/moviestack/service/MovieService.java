package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie createMovie(Movie newMovie);

    Movie updateMovie(Movie updateMovie);
    
    Movie getMovieById(String id);
    
    List<Movie> getMovies();
}
