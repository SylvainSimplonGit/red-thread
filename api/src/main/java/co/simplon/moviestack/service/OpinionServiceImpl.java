package co.simplon.moviestack.service;

import co.simplon.moviestack.model.Movie;
import co.simplon.moviestack.model.Opinion;
import co.simplon.moviestack.repository.OpinionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OpinionServiceImpl implements OpinionService {

    private OpinionRepository opinionRepository;

    public OpinionServiceImpl(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    @Override
    public Opinion createOpinion(Opinion newOpinion) {
        return opinionRepository.save(newOpinion);
    }

    @Override
    public void deleteOpinion(Opinion deleteOpinion) {
        opinionRepository.delete(deleteOpinion);
    }

    @Override
    public Opinion updateOpinion(Opinion updateOpinion) {
        return opinionRepository.save(updateOpinion);
    }

    @Override
    public Opinion getOpinionById(Long id) throws EntityNotFoundException {
        Optional<Opinion> dbOpinion = this.opinionRepository.findById(id);
        if(dbOpinion.isPresent()){
            return dbOpinion.get();
        } else {
            throw new EntityNotFoundException("Opinion with ID: " + id + " cannot be found in Opinion database");
        }
    }

    @Override
    public List<Opinion> getOpinions() {
        return opinionRepository.findAll();
    }

}
