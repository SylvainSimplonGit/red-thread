/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.simplon.moviestack.model.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Order;
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
    public void shouldReturnNotNullWhenAddMovieWithIdImbdAndTitle() throws Exception {
        Movie savedMovie = new Movie("tt7286456", "The Film !");
        this.movieRepository.save(savedMovie);
        assertThat(testEntityManager.find(Movie.class, 1L)).isNotNull();
    }

    @Test
//    @Order(1)
    public void shouldReturnNullWhenAddMovieWithOut() throws Exception {

        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            Movie savedMovie = new Movie();
            this.movieRepository.saveAndFlush(savedMovie);
        });
        String expectedMessageImdb = "interpolatedMessage='ne peut pas être nul', propertyPath=idImdb";
        String expectedMessageTitle = "interpolatedMessage='ne peut pas être nul', propertyPath=title";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessageImdb) && actualMessage.contains(expectedMessageTitle));
    }

}