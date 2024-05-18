package app.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokumentuak")
public class Dokumentuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String NAN;
    private String hizkuntzak;
    private String kurrikulum;
    private String beste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNAN() {
        return NAN;
    }

    public void setNAN(String NAN) {
        this.NAN = NAN;
    }

    public String getHizkuntzak() {
        return hizkuntzak;
    }

    public void setHizkuntzak(String hizkuntzak) {
        this.hizkuntzak = hizkuntzak;
    }

    public String getKurrikulum() {
        return kurrikulum;
    }

    public void setKurrikulum(String kurrikulum) {
        this.kurrikulum = kurrikulum;
    }

    public String getBeste() {
        return beste;
    }

    public void setBeste(String beste) {
        this.beste = beste;
    }
}
