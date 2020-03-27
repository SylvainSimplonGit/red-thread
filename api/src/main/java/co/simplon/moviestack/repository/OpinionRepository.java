package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {

//    @Query("select mo from Opinion mo join mo.movie mm where mm.idImdb = :idImdb")
//    @Query("select mo from Movie mm join mm.opinions mo where mm.idImdb = :idImdb")
//    List<Opinion> getListOfOpinionsByMovie(@Param("idImdb") String idImdb);
}
