/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.service;

import co.simplon.moviestack.exception.InvalidMovieBuffException;
import co.simplon.moviestack.exception.InvalidRequestException;
import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.repository.MovieBuffRepository;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
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
    public List<MovieBuff> getMovieBuffs() throws InvalidRequestException {
//        try {
            List<MovieBuff> dbMovieBuffs = movieBuffRepository.findAll();
            if (!dbMovieBuffs.isEmpty()) {
                return dbMovieBuffs;
            } else {
                throw new EntityNotFoundException(ERROR_NO_DATA_IN_DB);
            }
//        } catch (Exception e) {
//            this.errorManagement(e, methodName());
//        }
    }

    @Override
    public MovieBuff getMovieBuffById(Long idMovieBuff) {
//        try {
            Optional<MovieBuff> movieBuff = this.movieBuffRepository.findById(idMovieBuff);
            if (movieBuff.isPresent()) {
                return movieBuff.get();
            } else {
                throw new EntityNotFoundException(String.format(ERROR_NO_DATA_WITH_ID, idMovieBuff));
            }
//        } catch (Exception e) {
//            this.errorManagement(e, methodName(), idMovieBuff);
//        }
    }

    @Override
    public MovieBuff updateMovieBuff(Long idMovieBuff, MovieBuff updateMovieBuff) throws ConstraintViolationException {
//        try {
            if (movieBuffRepository.findById(idMovieBuff).isPresent()) {
                return movieBuffRepository.save(updateMovieBuff);
            } else {
                throw new EntityNotFoundException(String.format(ERROR_NO_DATA_WITH_ID, idMovieBuff));
            }
//        } catch (Exception e) {
//            this.errorManagement(e, methodName(), idMovieBuff);
//        } catch (ConstraintViolationException c) {
//            throw new InvalidRequestException(String.format(ERROR_NO_REQUEST_WITH_ID, idMovieBuff));
//            throw new ConstraintViolationException();
//        }
    }

    public static String methodName() { return Thread.currentThread().getStackTrace()[2].getMethodName(); }

    private void errorManagement(Exception e, String method, Long idMovieBuff) {
        if (e instanceof EntityNotFoundException) {
            String msg = String.format(ERROR_NO_DATA_WITH_ID, idMovieBuff);
            LOGGER.error(ERROR_LOGGER, method, msg);
            throw new EntityNotFoundException(msg);
        }

    }

//    private void errorManagement(Exception e, String method) throws InvalidRequestException {
//        if (e instanceof EntityNotFoundException) {
//            LOGGER.error(ERROR_LOGGER, method, ERROR_NO_DATA_IN_DB);
//            throw new EntityNotFoundException(ERROR_NO_DATA_IN_DB);
//        }
//        else if (e instanceof ConstraintViolationException) {
//            String msg = ERROR_NO_REQUEST_WITH_ID;
//            LOGGER.error(ERROR_LOGGER, method, msg);
//            throw new InvalidRequestException(msg);
//        }
//    }


}
