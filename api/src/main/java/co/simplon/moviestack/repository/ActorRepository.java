package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
