package co.simplon.moviestack.controler;

import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.service.MovieBuffService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/movies/movie_buff")
@CrossOrigin("*")
public class MovieBuffController {

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
    public List<MovieBuff> getMovieBuffs() {
        return movieBuffService.getMovieBuffs();
    }

    /**
     * Get movie buff with moviebuffId
     *
     * @param movieBuffId
     * @return
     */
    @GetMapping("/{movieBuffId}")
    public Object getMovieBuffById(@PathVariable Long movieBuffId) {
        try {
            return movieBuffService.getMovieBuffById(movieBuffId);
        } catch (EntityNotFoundException e) {
            return e.getMessage();
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


}
