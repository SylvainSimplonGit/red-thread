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

//import co.simplon.moviestack.model.Connection;
//import co.simplon.moviestack.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
    private String firstName;

    @Column()
    private String lastName;

//    @OneToMany(mappedBy = "connection")
//    private List<Connection> connections = new ArrayList<>();

    @ManyToMany(mappedBy = "movieBuffs")
    private List<Movie> moviesSeen;

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