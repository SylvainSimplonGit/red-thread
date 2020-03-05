package co.simplon.moviestack.controler;

import co.simplon.moviestack.model.MovieBuff;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.service.MovieBuffService;
import co.simplon.moviestack.service.OpinionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movies/movie_buff")
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


}
