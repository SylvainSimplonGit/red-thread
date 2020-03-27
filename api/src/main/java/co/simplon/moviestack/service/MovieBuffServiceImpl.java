/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.service;

import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.repository.MovieBuffRepository;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 *
 * @author franck
 */
@Service
public class MovieBuffServiceImpl implements MovieBuffService {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieBuffServiceImpl.class);

    static final String ERROR_LOGGER = "{} | {}";
    static final String ERROR_NO_DATA_IN_DB = "No movie buff in DB Movie";
    static final String ERROR_NO_DATA_WITH_ID = "The movie buff with ID: %s cannot be found in DB Movie";
    static final String ERROR_NO_REQUEST_WITH_ID = "Attributes are missing in request !";

    private MovieBuffRepository movieBuffRepository;

    public MovieBuffServiceImpl(MovieBuffRepository movieBuffRepository) {
        this.movieBuffRepository = movieBuffRepository;
    }
    
    @Override
    public List<MovieBuff> getMovieBuffs() {
        List<MovieBuff> dbMovieBuffs = movieBuffRepository.findAll();
        if (!dbMovieBuffs.isEmpty()) {
            return dbMovieBuffs;
        } else {
            throw new EntityNotFoundException(ERROR_NO_DATA_IN_DB);
        }
    }

    @Override
    public MovieBuff getMovieBuffById(Long idMovieBuff) {
        Optional<MovieBuff> movieBuff = this.movieBuffRepository.findById(idMovieBuff);
        if (movieBuff.isPresent()) {
            return movieBuff.get();
        } else {
            throw new EntityNotFoundException(String.format(ERROR_NO_DATA_WITH_ID, idMovieBuff));
        }
    }

    @Override
    public MovieBuff updateMovieBuff(Long idMovieBuff, MovieBuff updateMovieBuff) {
        if (movieBuffRepository.findById(idMovieBuff).isPresent()) {
            return movieBuffRepository.saveAndFlush(updateMovieBuff);
        } else {
            throw new EntityNotFoundException(String.format(ERROR_NO_DATA_WITH_ID, idMovieBuff));
        }
    }

    @Override
    public List<Opinion> getOpinionsByidMovieBuff(Long idMovieBuff) {
        return movieBuffRepository.getListOfOpinionsByMovieBuff(idMovieBuff);
    }
    
}
