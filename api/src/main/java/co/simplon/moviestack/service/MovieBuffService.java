/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.service;

import co.simplon.moviestack.exception.InvalidRequestException;
import co.simplon.moviestack.model.Movie;
import java.util.List;

import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import org.springframework.stereotype.Service;

/**
 *
 * @author franck 
 */
@Service
public interface MovieBuffService {

    List<MovieBuff> getMovieBuffs() throws InvalidRequestException;

    MovieBuff getMovieBuffById(Long IdMovieBuff);  
  
    MovieBuff updateMovieBuff(Long idMovieBuff, MovieBuff movieBuff) throws Exception;
  
    List<Opinion> getOpinionsByidMovieBuff(Long idMovieBuff);
}
