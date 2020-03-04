package co.simplon.moviestack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Connection {

    @Id
    @SequenceGenerator(name = "connection_seq_id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "connection_seq_id")
    private Long idConnection;

    @Column(nullable = false)
    @NotNull
    private String provider;

    @Column(nullable = false)
    @NotNull
    private String login;

    public Connection() {}

    public Connection (Long idConnection, String provider, String login) {
        this.idConnection = idConnection;
        this.provider = provider;
        this.login = login;
    }

    public Connection (String provider, String login) {
        this.provider = provider;
        this.login = login;
    }

    public Long getIdConnection() {
        return idConnection;
    }

    public String getProvider() {
        return provider;
    }

    public String getLogin() {
        return login;
    }

}
