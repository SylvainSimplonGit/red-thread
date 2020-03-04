package co.simplon.moviestack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Actor {

    @Id
    @SequenceGenerator(name = "actor_seq_id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq_id")
    @NotNull
    private Long idActor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    public Actor() {
        // Constructor by default
    }

    public Actor( Long idActor, String firstName,String lastName) {
        this.idActor = idActor;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
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
}
