package app.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enpresa")
public class Enpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    
    private String enpresa_izena;
    private String lokalidadea;
    private String NIF;
    private String email;
    private Integer helburua;
    
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
    public String getEnpresa_izena() {
        return enpresa_izena;
    }
    public void setEnpresa_izena(String enpresa_izena) {
        this.enpresa_izena = enpresa_izena;
    }
    public String getLokalidadea() {
        return lokalidadea;
    }
    public void setLokalidadea(String lokalidadea) {
        this.lokalidadea = lokalidadea;
    }
    public String getNIF() {
        return NIF;
    }
    public void setNIF(String nIF) {
        NIF = nIF;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getHelburua() {
        return helburua;
    }
    public void setHelburua(Integer helburua) {
        this.helburua = helburua;
    }

    
}
