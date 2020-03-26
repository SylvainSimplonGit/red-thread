package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Opinion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpinionService {

    Opinion createOpinion(Opinion newOpinion);

    void deleteOpinion(Opinion deleteOpinion);

    Opinion updateOpinion(Opinion updateOpinion);

    Opinion getOpinionById(Long id);

    List<Opinion> getOpinions();

}
