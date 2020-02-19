package co.simplon.moviestack.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Opinion {

    @Id
    @SequenceGenerator(name = "opinion_seq_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinion_seq_id")
    private Long idOpinion;

    @Column(nullable = false)
    private Long idMovieBuff;

    @Column(nullable = false)
    @Min(value = 0)
    @Max(value = 10)
    private Float rating;

    @Column(nullable = true)
    private String comment;

    public Opinion() {
    }

    public Opinion(Long idMovieBuff, Float rating, String comment) {
        this.idMovieBuff = idMovieBuff;
        this.rating = rating;
        this.comment = comment;
    }

    public Opinion(Long idOpinion, Long idMovieBuff, Float rating, String comment) {
        this.idOpinion = idOpinion;
        this.idMovieBuff = idMovieBuff;
        this.rating = rating;
        this.comment = comment;
    }

}
