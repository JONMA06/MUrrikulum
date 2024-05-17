package app.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String erabiltzailea;
    private String pasahitza;
    private String rola;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    
}
