package co.simplon.moviestack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

}