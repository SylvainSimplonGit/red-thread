package co.simplon.moviestack.model;

import javax.persistence.*;

@Entity
public class Opinion {

    @Id
    @SequenceGenerator(name = "opinion_seq_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinion_seq_id")
    private Long idOpinion;

    private Long idMovieBuff;

    @Column(nullable = false)
    private Integer rating;

    private String comment;

    public Long getIdOpinion() {
        return idOpinion;
    }

    public Long getIdMovieBuff() {
        return idMovieBuff;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
