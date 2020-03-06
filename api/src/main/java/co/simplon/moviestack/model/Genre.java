package co.simplon.moviestack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="mv_genre")
public class Genre {

    @Id
    @Column(nullable = false)
    @NotNull
    private Long idGenre;

    @Column(nullable = false)
    @NotNull
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    public Genre() {
    }

    public Genre(Long id, String name) {
        this.idGenre = id;
        this.name = name;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
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