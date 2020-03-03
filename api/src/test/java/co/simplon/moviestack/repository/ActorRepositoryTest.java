package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Actor;
import co.simplon.moviestack.model.Movie;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void shouldReturnNotNullWhenAddActorValid() throws Exception {
        Actor savedActor = new Actor(1L, "Clint", "Eastwood");
        this.actorRepository.save(savedActor);
        assertThat(testEntityManager.find(Actor.class, 1L)).isNotNull();
    }

    @Test
    public void shouldReturnNullAndErrorNotificationWhenAddActorWithoutFirstName() throws Exception {
        Actor savedActor = new Actor(1L, null, "Eastwood");
        this.actorRepository.save(savedActor);
        assertThat(actorRepository.findById(1L).get().getFirstName()).withFailMessage("Error - No actor firstName documented").isNull();
    }

    @Test
    public void shouldReturnNullAndErrorNotificationWhenAddActorWithoutLastName() throws Exception {
        Actor savedActor = new Actor(1L, "Clint", null);
        this.actorRepository.save(savedActor);
        assertThat(actorRepository.findById(1L).get().getLastName()).withFailMessage("Error - No actor LastName documented").isNull();
    }

    @Test
    public void shouldReturnSize1AndErrorNotificationWhenAddActorWithoutId() throws Exception {
        Actor savedActor = new Actor(null, "Clint", "Eastwood");
        this.actorRepository.save(savedActor);
        assertThat(actorRepository.findAll()).hasSize(1).withFailMessage("Error - No idActor documented");
    }


}
