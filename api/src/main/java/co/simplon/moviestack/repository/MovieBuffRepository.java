package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.MovieBuff;
import java.util.List;

import co.simplon.moviestack.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieBuffRepository extends JpaRepository<MovieBuff, Long> {

//    @Query("select mo from Opinion mo join mo.movieBuff mm where mm.idMovieBuff = :idMovieBuff")
    @Query("select mo from Opinion mo join mo.movieBuff mm where mm.idMovieBuff = :idMovieBuff")
    List<Opinion> getListOfOpinionsByMovieBuff(@Param("idMovieBuff") Long idMovieBuff);

}
