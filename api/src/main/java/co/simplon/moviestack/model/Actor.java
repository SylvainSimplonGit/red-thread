package co.simplon.moviestack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="mv_actor")
public class Actor {

    @Id
//    @SequenceGenerator(name = "actor_seq_id", sequenceName = "actor_seq_id", allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq_id")
    @NotNull
    private Long idActor;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    public Actor() {
        // Constructor by default
    }

    public Actor( Long idActor, String name) {
        this.idActor = idActor;
        this.name = name;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
