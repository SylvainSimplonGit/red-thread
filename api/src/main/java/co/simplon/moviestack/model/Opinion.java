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

    @ManyToOne
    private Movie movie;

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

    public Opinion(Movie movie, Long idMovieBuff, Float rating, String comment) {
        this.movie = movie;
        this.idMovieBuff = idMovieBuff;
        this.rating = rating;
        this.comment = comment;
    }

    public Opinion(Long idOpinion, Movie movie, Long idMovieBuff, Float rating, String comment) {
        this.idOpinion = idOpinion;
        this.movie = movie;
        this.idMovieBuff = idMovieBuff;
        this.rating = rating;
        this.comment = comment;
    }

}
