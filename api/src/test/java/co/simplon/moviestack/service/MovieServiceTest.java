package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    private MovieService movieService;

    @BeforeEach
    public void setUp() throws Exception {
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Test
    public void createMovie() {
        Movie movieMock = new Movie("tt000000", "The Test Film");
        given(movieRepository.save(movieMock)).willReturn(new Movie("tt000000", "The Test Film"));

        Movie savedMovie = movieService.createMovie(movieMock);
        assertThat(savedMovie.getImdbId()).isEqualTo("tt000000");
        assertThat(savedMovie.getTitle()).isEqualTo("The Test Film");
    }



}
