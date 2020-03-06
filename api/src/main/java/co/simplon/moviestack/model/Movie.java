/**
 *
 * @startuml
 *
 * class Movie {
 *  idMovie: Integer
 *  title: String
 *  director: String
 *  released: Date
 *  runtime: Integer
 *  genres: Genre[]
 *  actors: Actor[]
 *  plot: String
 *  imdbRating: Float
 *  imdbVote: integer
 *  rated: Rate
 *  opinions: Opinion[]
 *
 *  getMovieFromOmdbById(imdbId: String)
 *  getMovieFromOmdbByName(name: String)
 *}
 *
 * Movie                 "0..n" -- "1..n"     Genre : a
 * Movie                 "0..n" -- "1..n"     Actor : a
 * Movie                 "1"    -- "0..n"     Opinion : a
 * Movie                 "0..n" -- "1"        Rate : est classé
 *
 * @enduml
 *
 *
 */
package co.simplon.moviestack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Franck
 */
@Entity
@Table(name="mv_movie")
public class Movie {

    @Id
    @Column(nullable = false)
    @NotNull
    private String idImdb;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column()
    private String director;

    @Column()
    private String released;

    @Column()
    private Integer runtime;

    @Column(length = 700)
    private String plot;

    @Column()
    private Float imdbRating;

    @Column()
    private Integer imdbVote;

//    @Enumerated(EnumType.STRING)
//    private Rate rated;

    @OneToMany
    private List<Genre> genres;

    @JsonIgnore
    // TODO Ajouter une @Query dans le MovieRepository
    @OneToMany(mappedBy = "movie")
    private List<Opinion> opinions;

    @JsonIgnore
    @ManyToMany(mappedBy = "moviesSeen")
    private List<MovieBuff> movieBuffs;

    @ManyToMany
    @JoinTable(
            name = "mv_actor_movies",
            joinColumns =
            @JoinColumn (name = "movies_id_imdb"),
            inverseJoinColumns = @JoinColumn ( name = "actors_id_actor")
    )
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String idImdbMovie, String title) {
        this.idImdb = idImdbMovie;
        this.title = title;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public List<MovieBuff> getMovieBuffs() {
        return movieBuffs;
    }

    public void setMovieBuffs(List<MovieBuff> movieBuffs) {
        this.movieBuffs = movieBuffs;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getImdbVote() {
        return imdbVote;
    }

    public void setImdbVote(Integer imdbVote) {
        this.imdbVote = imdbVote;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
