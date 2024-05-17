package app.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class LanBila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    
    private String izena;
    private String abizena;
    private String lokalidadea;
    private Integer adina;
    private String email;
    
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
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getAbizena() {
        return abizena;
    }
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }
    public String getLokalidadea() {
        return lokalidadea;
    }
    public void setLokalidadea(String lokalidadea) {
        this.lokalidadea = lokalidadea;
    }
    public Integer getAdina() {
        return adina;
    }
    public void setAdina(Integer adina) {
        this.adina = adina;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
