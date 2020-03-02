package co.simplon.moviestack.model;

import javax.persistence.*;

@Entity
public class Connection {

    @Id
    @SequenceGenerator(name = "connection_seq_id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "connection_seq_id")
    private Long idConnection;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String login;

    public Long getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(Long idConnection) {
        this.idConnection = idConnection;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
