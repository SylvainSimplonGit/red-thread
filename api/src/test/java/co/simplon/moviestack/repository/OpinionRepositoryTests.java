package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase
public class OpinionRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieBuffRepository movieBuffRepository;

    @Test
    public void shouldReturnNotNullWhenAddOpinionValid() throws Exception {
        Movie movie = new Movie("tt0000001", "The Film !");
        this.movieRepository.save(movie);
        MovieBuff movieBuff = new MovieBuff(10L, "The", "Test");
        this.movieBuffRepository.save(movieBuff);
        Opinion savedOpinion = new Opinion(1L, movie, movieBuff, 5.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(testEntityManager.find(Opinion.class, 1L)).isNotNull();
    }

//    @Test
//    public void shouldReturnSize1WhenAddOpinionWithoutId() throws Exception {
//        Movie movie = new Movie("tt7286456", "The Film !");
//        this.movieRepository.save(movie);
//        Opinion savedOpinion = new Opinion( movie, 1L, 5.0F, "Film pas Ouf !");
//        this.opinionRepository.save(savedOpinion);
//        assertThat(opinionRepository.findAll()).hasSize(1);
//    }

//    @Test
//    public void shouldReturnNullWhenAddOpinionWithTooBigRating() throws Exception {
//        Movie movie = new Movie("tt0000002", "The Film !");
//        this.movieRepository.save(movie);
//        Opinion savedOpinion = new Opinion(1L, movie, 1L, 15.0F, "Film pas Ouf !");
//        this.opinionRepository.save(savedOpinion);
//        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
//    }

//    @Test
//    public void shouldReturnNullWhenAddOpinionWithNegativeRating() throws Exception {
//        Movie movie = new Movie("tt0000003", "The Film !");
//        this.movieRepository.save(movie);
//        Opinion savedOpinion = new Opinion(1L, movie, 1L, -5.0F, "Film pas Ouf !");
//        this.opinionRepository.save(savedOpinion);
//        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
//    }

//    @Test
////    @Order(1)
//    public void shouldReturnSize1WhenAddOpinionWithoutComment() throws Exception {
//        Movie movie = new Movie("tt0000004", "The Film !");
//        this.movieRepository.save(movie);
//        Opinion savedOpinion = new Opinion(movie, 1L, 5.0F, null);
//        this.opinionRepository.saveAndFlush(savedOpinion);
//        assertThat(opinionRepository.findAll()).hasSize(1);
//    }

//    @Test
//    public void shouldReturnNullWhenAddOpinionWithoutIdMovieBuff() throws Exception {
//        Movie movie = new Movie("tt0000005", "The Film !");
//        this.movieRepository.save(movie);
//        Opinion savedOpinion = new Opinion(1L, movie, null, 5.0F, "Film pas Ouf !");
//        this.opinionRepository.save(savedOpinion);
//        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
//    }

    @AfterEach
    public void clearDatas() {
        testEntityManager.clear();
    }
}
