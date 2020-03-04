package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.MovieBuff;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieBuffRepository extends JpaRepository<MovieBuff, Long> {
    @Query("SELECT * FROM Movie WHERE id IN (SELECT id FROM movie_buff")
    List<Movie> getMoviesSeen();
}
