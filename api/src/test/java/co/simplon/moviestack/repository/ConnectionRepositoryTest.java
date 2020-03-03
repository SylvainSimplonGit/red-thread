package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Connection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ConnectionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Test
    public void shouldReturnNotNullWhenAddConnectionValid() throws Exception {
        Connection savedConnection = new Connection(1L, "Facebook", "login");
        this.connectionRepository.save(savedConnection);
        assertThat(testEntityManager.find(Connection.class, 1L)).isNotNull();
    }

    @Test
    public void shouldReturnNullAndErrorNotificationWhenAddConnectionWithoutProvider() throws Exception {
        Connection savedConnection = new Connection(1L, null, "login");
        this.connectionRepository.save(savedConnection);
        assertThat(testEntityManager.find(Connection.class, 1L)).withFailMessage("Error - No Connection provider documented").isNull();
    }

    @Test
    public void shouldReturnNullAndErrorNotificationWhenAddConnectionWithoutLogin() throws Exception {
        Connection savedConnection = new Connection(1L, "Facebook", null);
        this.connectionRepository.save(savedConnection);
        assertThat(connectionRepository.findById(1L).get().getLogin()).withFailMessage("Error - No Connection login documented").isNull();
    }

    @Test
    public void shouldReturnSize1AndErrorNotificationWhenAddConnectionWithoutId() throws Exception {
        Connection savedConnection = new Connection(null, "Facebook", "login");
        this.connectionRepository.save(savedConnection);
        assertThat(connectionRepository.findAll()).hasSize(1).withFailMessage("Error - No idConnection documented");
    }



}
