/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author a178423
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldReturnNotNullWhenAddMovieValid() throws Exception {
        Movie savedMovie = new Movie(1L, "The Film !");
        this.movieRepository.save(savedMovie);
        assertThat(testEntityManager.find(Movie.class, 1L)).isNotNull();
    }

}
