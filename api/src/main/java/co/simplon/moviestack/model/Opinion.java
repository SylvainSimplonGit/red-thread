package co.simplon.moviestack.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="mv_opinion")
public class Opinion {

    @Id
    @SequenceGenerator(name = "opinion_seq_id", sequenceName = "opinion_seq_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinion_seq_id")
    private Long idOpinion;

    @ManyToOne
    private Movie movie;

//    @Column(nullable = false)
//    private Long idMovieBuff;
    @ManyToOne
    private MovieBuff movieBuff;

    @Column(nullable = false)
    @Min(value = 0)
    @Max(value = 10)
    private Float rating;

    @Column(nullable = true)
    private String comment;

    public Opinion() {
    }

//    public Opinion(Movie movie, Long idMovieBuff, Float rating, String comment) {
//        this.movie = movie;
//        this.idMovieBuff = idMovieBuff;
//        this.rating = rating;
//        this.comment = comment;
//    }

    public Opinion(Movie movie, MovieBuff movieBuff, Float rating, String comment) {
        this.movie = movie;
        this.movieBuff = movieBuff;
        this.rating = rating;
        this.comment = comment;
    }

//    public Opinion(Long idOpinion, Movie movie, Long idMovieBuff, Float rating, String comment) {
//        this.idOpinion = idOpinion;
//        this.movie = movie;
//        this.idMovieBuff = idMovieBuff;
//        this.rating = rating;
//        this.comment = comment;
//    }

    public Opinion(Long idOpinion, Movie movie, MovieBuff movieBuff, Float rating, String comment) {
        this.idOpinion = idOpinion;
        this.movie = movie;
        this.movieBuff = movieBuff;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Long idOpinion) {
        this.idOpinion = idOpinion;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

//    public Long getIdMovieBuff() {
//        return idMovieBuff;
//    }
//
//    public void setIdMovieBuff(Long idMovieBuff) {
//        this.idMovieBuff = idMovieBuff;
//    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MovieBuff getMovieBuff() {
        return movieBuff;
    }

    public void setMovieBuff(MovieBuff movieBuff) {
        this.movieBuff = movieBuff;
    }

}
