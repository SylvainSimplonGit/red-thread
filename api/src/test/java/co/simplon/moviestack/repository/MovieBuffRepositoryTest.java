/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.MovieBuff;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author franck 
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieBuffRepositoryTest {
    
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MovieBuffRepository movieBuffRepository;
    
    public void shouldReturnNotNullWhenAddMovieBuffValid() throws Exception {
        MovieBuff movieBuff = new MovieBuff(1L, "Tete", "DENOEUX");
        this.movieBuffRepository.save(movieBuff);
        assertThat(testEntityManager.find(MovieBuff.class, 1L)).isNotNull();
    }
}
