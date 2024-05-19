package app.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String erabiltzailea;
    private String pasahitza;
    private String rola;

    @OneToMany(mappedBy = "user")
    private List<Enpresa> enpresak;

    @OneToMany(mappedBy = "user")
    private List<LanBila> lanBilak;

    @OneToMany(mappedBy = "user")
    private List<Dokumentuak> dokumentuak;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public List<Enpresa> getEnpresak() {
        return enpresak;
    }

    public void setEnpresak(List<Enpresa> enpresak) {
        this.enpresak = enpresak;
    }

    public List<LanBila> getLanBilak() {
        return lanBilak;
    }

    public void setLanBilak(List<LanBila> lanBilak) {
        this.lanBilak = lanBilak;
    }

    public List<Dokumentuak> getDokumentuak() {
        return dokumentuak;
    }

    public void setDokumentuak(List<Dokumentuak> dokumentuak) {
        this.dokumentuak = dokumentuak;
    }
}
