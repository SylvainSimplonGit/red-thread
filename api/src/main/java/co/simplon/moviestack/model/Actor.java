package co.simplon.moviestack.model;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @SequenceGenerator(name = "actor_seq_id", allocationSize = 1000, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq_id")
    private Long idActor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    public Actor() {
        // Constructor by default
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
