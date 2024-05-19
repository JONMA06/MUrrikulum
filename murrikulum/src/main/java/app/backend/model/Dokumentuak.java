package app.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokumentuak")
public class Dokumentuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String NAN;
    private String hizkuntzak;
    private String kurrikulum;
    private String beste;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
