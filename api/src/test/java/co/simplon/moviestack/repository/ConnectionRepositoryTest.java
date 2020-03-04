package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Connection;
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
@AutoConfigureTestDatabase
public class ConnectionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Test
    @Order(1)
    public void shouldReturnNotNullWhenAddConnectionValid() throws Exception {
        Connection savedConnection = new Connection("Facebook", "login");
        this.connectionRepository.save(savedConnection);
        assertThat(connectionRepository.findByprovider("Facebook").get().getLogin()).isNotNull();
        assertThat(connectionRepository.findBylogin("login").get().getProvider()).isNotNull();
    }

    @Test
    @Order(3)
    public void shouldReturnNullWhenAddConnectionWithoutProvider() throws Exception {
        Connection savedConnection2 = new Connection(3L, null, "login2");
        this.connectionRepository.save(savedConnection2);
        assertThat(connectionRepository.findById(3L).get().getProvider()).isNull();
    }

    @Test
    @Order(2)
    public void shouldReturnNullWhenAddConnectionWithoutLogin() throws Exception {
        Connection savedConnection3 = new Connection(2L,"Google", null);
        this.connectionRepository.save(savedConnection3);
        assertThat(connectionRepository.findById(2L).get().getLogin()).isNull();
    }

    @Test
    @Order(4)
    public void shouldReturnIsEmptyWhenAddConnectionWithoutId() throws Exception {
        Connection savedConnection4 = new Connection("Amazon", "login3");
        this.connectionRepository.save(savedConnection4);
        assertThat(connectionRepository.findAll()).hasSize(1);
    }
}
