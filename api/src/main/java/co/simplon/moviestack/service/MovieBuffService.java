/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author franck 
 */
@Service
public interface MovieBuffService {
    List<Movie> getMoviesSeen();
}
