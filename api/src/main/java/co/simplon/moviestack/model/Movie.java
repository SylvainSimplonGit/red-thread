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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Franck
 */
@Entity
public class Movie {

    @Id
    private Long idMovie;
    @SequenceGenerator(name = "movie_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq_id")

    @Column(nullable = false)
    private String title;

    @Column()
    private String director;

    @Column()
    private String released;

    @Column()
    private Integer runtime;

    @Column()
    private String plot;

    @Column()
    private Float imdbRating;

    @Column()
    private Integer imdbVote;

    @Enumerated(EnumType.STRING)
    private Rate rated;

    @OneToMany(mappedBy = "genre")
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "actor")
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "opinion")
    private List<Opinion> opinions = new ArrayList<>();

}
