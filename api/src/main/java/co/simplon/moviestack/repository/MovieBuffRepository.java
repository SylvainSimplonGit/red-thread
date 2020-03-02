package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.MovieBuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieBuffRepository extends JpaRepository<MovieBuff, Long> {
}
