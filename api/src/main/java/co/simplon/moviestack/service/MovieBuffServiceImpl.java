/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.service;

import co.simplon.moviestack.exception.InvalidMovieBuffException;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.repository.MovieBuffRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 *
 * @author franck
 */
@Service
public class MovieBuffServiceImpl implements MovieBuffService {

    private MovieBuffRepository movieBuffRepository;

    public MovieBuffServiceImpl(MovieBuffRepository movieBuffRepository) {
        this.movieBuffRepository = movieBuffRepository;
    }
    
    @Override
    public List<MovieBuff> getMovieBuffs() {
        return this.movieBuffRepository.findAll();
    }

    @Override
    public MovieBuff getMovieBuffById(Long idMovieBuff) {
        Optional<MovieBuff> movieBuff = this.movieBuffRepository.findById(idMovieBuff);
        if (movieBuff.isPresent()) {
            return movieBuff.get();
        } else {
            // Extension de RuntimeException
            throw new InvalidMovieBuffException();
//            throw new RuntimeException();
        }
    }
    
}
