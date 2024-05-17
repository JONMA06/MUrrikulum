package app.backend.model;

import javax.persistence.*;

@Entity
public class Dokumentuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idLanBila", nullable = false)
    private LanBila lanBila;
    
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
    public LanBila getLanBila() {
        return lanBila;
    }
    public void setLanBila(LanBila lanBila) {
        this.lanBila = lanBila;
    }
    public String getNAN() {
        return NAN;
    }
    public void setNAN(String nAN) {
        NAN = nAN;
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
