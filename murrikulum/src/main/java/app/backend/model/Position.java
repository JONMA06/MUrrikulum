package app.backend.model;

public class Position {
    private String lanIzena;
    private String enpresaIzena;
    private String lokalidadea;
    private String soldata;
    private String sektorea;
    private String hizkuntza;
    private String hezkuntza;
    private String modua;

    public Position(String lanIzena, String enpresaIzena, String lokalidadea, String soldata, String sektorea,
            String hizkuntza, String hezkuntza, String modua) {
        this.lanIzena = lanIzena;
        this.enpresaIzena = enpresaIzena;
        this.lokalidadea = lokalidadea;
        this.soldata = soldata;
        this.sektorea = sektorea;
        this.hizkuntza = hizkuntza;
        this.hezkuntza = hezkuntza;
        this.modua = modua;
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

    public String getSoldata() {
        return soldata;
    }

    public void setSoldata(String soldata) {
        this.soldata = soldata;
    }

    public String getSektorea() {
        return sektorea;
    }

    public void setSektorea(String sektorea) {
        this.sektorea = sektorea;
    }

    public String getHizkuntza() {
        return hizkuntza;
    }

    public void setHizkuntza(String hizkuntza) {
        this.hizkuntza = hizkuntza;
    }

    public String getHezkuntza() {
        return hezkuntza;
    }

    public void setHezkuntza(String hezkuntza) {
        this.hezkuntza = hezkuntza;
    }

    public String getModua() {
        return modua;
    }

    public void setModua(String modua) {
        this.modua = modua;
    }

    public String getLanIzena() {
        return lanIzena;
    }

    public void setLanIzena(String lanIzena) {
        this.lanIzena = lanIzena;
    }
}
