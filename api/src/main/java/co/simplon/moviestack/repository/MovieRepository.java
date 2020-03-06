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
//    @Query()
//    public List<Opinion> getListOfOpinionsByMovie(@Param("idPlayer") Long idPlayer);
}
