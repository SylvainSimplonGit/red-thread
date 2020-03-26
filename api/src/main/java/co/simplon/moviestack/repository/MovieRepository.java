/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author a178423
 */
public interface MovieRepository extends JpaRepository<Movie, String> {

    @Query("select mo from Opinion mo join mo.movie mm where mm.idImdb = :idImdb")
//    @Query("select mo from Movie mm join mm.opinions mo where mm.idImdb = :idImdb")
//    select * from mv_opinion mo join mv_moviebuff mb ON mb.id_movie_buff = mo.id_opinion where movie_id_imdb = 'tt0078907';
//    @Query(nativeQuery = true,value = "select * from mv_opinion mo join mv_moviebuff mb ON mb.id_movie_buff = mo.id_opinion where movie_id_imdb = :idImdb")
    List<Opinion> getListOfOpinionsByMovie(@Param("idImdb") String idImdb);

}
