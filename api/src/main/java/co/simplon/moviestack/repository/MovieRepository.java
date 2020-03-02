package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
