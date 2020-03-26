/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
@startuml
class MovieBuff {
  idMovieBuff: Long
  firstName: String
  lastName: String
  connections: Connection[] 
  moviesSeen: Movie[]
}
@enduml
 */
package co.simplon.moviestack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author utilisateur
 *
 */
@Entity
@Table(name="mv_moviebuff")
public class MovieBuff {

    @Id
    @SequenceGenerator(name = "movie_buff_seq_id", sequenceName = "movie_buff_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_buff_seq_id")
    private Long idMovieBuff;

    @Column()
    @NotNull
    private String firstName;

    @Column()
    @NotNull
    private String lastName;

//    @OneToMany(mappedBy = "connection")
//    private List<Connection> connections = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "mv_movie_movie_buff",
            joinColumns =
            @JoinColumn (name = "movie_buffs_id_movie_buff"),
            inverseJoinColumns = @JoinColumn ( name = "movies_seen_id_imdb")
    )
    private List<Movie> moviesSeen;

    @JsonIgnore
    // TODO Ajouter une @Query dans le MovieRepository
    @OneToMany(mappedBy = "movieBuff")
    private List<Opinion> opinions;

    public MovieBuff() {
    }

    public MovieBuff(Long id, String firstName, String lastName) {
        this.idMovieBuff = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdMovieBuff() {
        return idMovieBuff;
    }

    public void setIdMovieBuff(Long idMovieBuff) {
        this.idMovieBuff = idMovieBuff;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Connection> getConnections() {
//        return connections;
//    }
//    public void setConnections(List<Connection> connections) {
//        this.connections = connections;
//    }
    
    public List<Movie> getMoviesSeen() {
        return moviesSeen;
    }

    public void setMoviesSeen(List<Movie> moviesSeen) {
        this.moviesSeen = moviesSeen;
    }

}
