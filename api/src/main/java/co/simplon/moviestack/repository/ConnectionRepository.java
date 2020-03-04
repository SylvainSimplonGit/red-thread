package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    Optional<Connection> findBylogin(String login);
    Optional<Connection> findByprovider(String provider);
}
