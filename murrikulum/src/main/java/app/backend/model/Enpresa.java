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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User  user;

    private String enpresaIzena;
    private String lokalidadea;
    private String NIF;
    private String email;
    private Integer helburua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnpresaIzena() {
        return enpresaIzena;
    }

    public void setEnpresaIzena(String enpresaIzena) {
        this.enpresaIzena = enpresaIzena;
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

    public void setNIF(String NIF) {
        this.NIF = NIF;
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
