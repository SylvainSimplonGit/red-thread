package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
