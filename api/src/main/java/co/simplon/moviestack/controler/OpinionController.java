package co.simplon.moviestack.controler;

import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.service.OpinionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/movies/opinion")
@CrossOrigin("*")
public class OpinionController {

    private OpinionService opinionService;

    /**
     * Constructor
     *
     * @param opinionService
     */
    public OpinionController(OpinionService opinionService) { this.opinionService = opinionService; }

    /**
     * Get the complete opinions list
     *
     * @return
     */
    @GetMapping
    public List<Opinion> getOpinions() {
        return opinionService.getOpinions();
    }

    /**
     * Get opinion with opinionId
     *
     * @param opinionId
     * @return
     */
    @GetMapping("/{opinionId}")
    public Opinion getOpinionById(@PathVariable Long opinionId) {
        return opinionService.getOpinionById(opinionId);
    }

    /**
     * Create an opinion
     *
     * @param newOpinion
     * @return
     */
    @PostMapping
    public Opinion createOpinion(@RequestBody @Valid Opinion newOpinion) {
        return opinionService.createOpinion(newOpinion);
    }

    /**
     * Update an opinion
     *
     * @param updateOpinion
     * @return
     */
    @PutMapping
    public Opinion updateOpinion(@RequestBody @Valid Opinion updateOpinion) {
        return opinionService.updateOpinion(updateOpinion);
    }

    /**
     * Delete an opinion
     *
     * @param deleteOpinion
     */
    @DeleteMapping
    public void deleteOpinion(@RequestBody @Valid Opinion deleteOpinion) {
        opinionService.deleteOpinion(deleteOpinion);
    }

}
