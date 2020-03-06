package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class ActorRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ActorRepository actorRepository;

//    @Test
//    public void shouldReturnNotNullWhenAddActorWithoutId() throws Exception {
//        Actor savedActor = new Actor(null, "Clint Eastwood");
//        this.actorRepository.save(savedActor);
//        assertThat(actorRepository.findAll()).hasSize(1);
//    }

//    @Test
//    public void shouldReturnNotNullWhenAddActorValid() throws Exception {
//        Actor savedActor = new Actor(10L, "Clint Eastwood");
//        this.actorRepository.save(savedActor);
//        assertThat(actorRepository.findAll()).hasSize(1);
//    }

//    @Test
//    public void shouldReturnNullAndErrorNotificationWhenAddActorWithoutName() throws Exception {
//        Actor savedActor = new Actor(2L, null);
//        this.actorRepository.save(savedActor);
//        assertThat(testEntityManager.find(Actor.class, 2L)).isNull();
//    }

    @AfterEach
    public void clearDatas() {
        testEntityManager.clear();
    }

}
