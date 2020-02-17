/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.repository;

import co.simplon.moviestack.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a178423
 */
public interface MovieReposittory extends JpaRepository<Movie, Long> {
    
}
