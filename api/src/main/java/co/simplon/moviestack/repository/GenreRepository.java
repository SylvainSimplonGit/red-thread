package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
