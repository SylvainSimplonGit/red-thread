package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Opinion;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OpinionRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OpinionRepository opinionRepository;

    @Test
    public void shouldReturnNotNullWhenAddOpinionValid() throws Exception {
        Opinion savedOpinion = new Opinion(1L, 1L, 5.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(testEntityManager.find(Opinion.class, 1L)).isNotNull();
    }

    @Test
    public void shouldReturnSize1WhenAddOpinionWithoutId() throws Exception {
        Opinion savedOpinion = new Opinion( 1L, 5.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(opinionRepository.findAll()).hasSize(1);
    }

    @Test
    public void shouldReturnNullWhenAddOpinionWithTooBigRating() throws Exception {
        Opinion savedOpinion = new Opinion(1L, 1L, 15.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
    }

    @Test
    public void shouldReturnNullWhenAddOpinionWithNegativeRating() throws Exception {
        Opinion savedOpinion = new Opinion(1L, 1L, -5.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
    }

    @Test
    @Order(1)
    public void shouldReturnSize1WhenAddOpinionWithoutComment() throws Exception {
        Opinion savedOpinion = new Opinion(1L, 5.0F, null);
        this.opinionRepository.save(savedOpinion);
        assertThat(opinionRepository.findAll()).hasSize(1);
    }

    @Test
    public void shouldReturnNullWhenAddOpinionWithoutIdMovieBuff() throws Exception {
        Opinion savedOpinion = new Opinion(1L, null, 5.0F, "Film pas Ouf !");
        this.opinionRepository.save(savedOpinion);
        assertThat(testEntityManager.find(Opinion.class, 1L)).isNull();
    }

}
