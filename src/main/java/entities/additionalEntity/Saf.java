package entities.additionalEntity;

import entities.User;

import javax.persistence.*;

@Entity
@Table(name = "saf")
public class Saf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_saf;

//    @Column(name = "id_user")
    @OneToOne()
    @JoinColumns(@JoinColumn(name = "id_user", referencedColumnName = "id"))
    private User id_user;

//    @Column(name = "id_subscriber")
    @OneToOne
    @JoinColumns(@JoinColumn(name = "id_subscriber", referencedColumnName = "id"))
    private User id_subscriber;

    public Saf(User id_user, User id_subscriber) {
        this.id_user = id_user;
        this.id_subscriber = id_subscriber;
    }

    public Saf() {
    }

    public int getId_saf() {
        return id_saf;
    }

    public void setId_saf(int id_saf) {
        this.id_saf = id_saf;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public User getId_subscriber() {
        return id_subscriber;
    }

    public void setId_subscriber(User id_subscriber) {
        this.id_subscriber = id_subscriber;
    }
}
