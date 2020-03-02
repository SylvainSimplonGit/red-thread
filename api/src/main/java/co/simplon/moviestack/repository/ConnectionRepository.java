package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {
}
