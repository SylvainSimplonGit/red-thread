package co.simplon.moviestack.controler;

import antlr.ASTFactory;
import co.simplon.moviestack.exception.InvalidRequestException;
import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.service.MovieBuffService;
import co.simplon.moviestack.service.MovieBuffServiceImpl;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/movies/movie_buff")
@CrossOrigin("*")
public class MovieBuffController {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieBuffController.class);

    private MovieBuffService movieBuffService;

    /**
     * Constructor
     *
     * @param movieBuffService
     */
    public MovieBuffController(MovieBuffService movieBuffService) {
        this.movieBuffService = movieBuffService;
    }


    /**
     * Get the complete movie Buff list
     *
     * @return
     */
    @GetMapping
    public List<MovieBuff> getMovieBuffs() throws InvalidRequestException {
        return movieBuffService.getMovieBuffs();
    }

    /**
     * Get movie buff with moviebuffId
     *
     * @param movieBuffId
     * @return
     */
    @GetMapping("/{movieBuffId}")
    public Object getMovieBuffById(@PathVariable Long movieBuffId) throws InvalidRequestException {
        try {
            return movieBuffService.getMovieBuffById(movieBuffId);
        } catch (Exception e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                LOGGER.error(e.getMessage());
                throw new InvalidRequestException("Attributes are missing in request !");
            }
            else {
                throw new InvalidRequestException("test!");
            }
        }
    }

    /**
     * Get opinions from TheMovieDB with Movie Buff Id
     *
     * @param movieBuffId
     * @return
     */
    @GetMapping("/{movieBuffId}/opinions")
    public List<Opinion> getOpinionsByImdbId(@PathVariable Long movieBuffId) {
        return movieBuffService.getOpinionsByidMovieBuff(movieBuffId);
    }

    /**
     * Update movie buff with moviebuffId
     *
     * @param movieBuffId
     * @return
     */
    @PutMapping("/{movieBuffId}")
    public Object putMovieBuffById(@PathVariable Long movieBuffId, @RequestBody MovieBuff movieBuff) throws Exception {
        try {
            return movieBuffService.updateMovieBuff(movieBuffId, movieBuff);
        } catch (EntityNotFoundException | InvalidRequestException e) {
            return e.getMessage();
        }
    }

}
