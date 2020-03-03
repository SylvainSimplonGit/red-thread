package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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
    public Movie getMovieById(Long id) throws EntityNotFoundException {
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
}
