package app.backend.model;

public class Course {
    private String kurtsoIzena;
    private String lokalidadea;
    private String sektorea;
    private String hizkuntza;
    private String modua;
    private String difficulty;
    private String length;
    private int rating;

    public Course(String kurtsoIzena, String lokalidadea, String sektorea,
            String hizkuntza, String modua, String difficulty, String length, int rating) {
        this.kurtsoIzena = kurtsoIzena;
        this.lokalidadea = lokalidadea;
        this.sektorea = sektorea;
        this.hizkuntza = hizkuntza;
        this.modua = modua;
        this.difficulty = difficulty;
        this.length = length;
        this.rating = rating;
    }

    public String getKurtsoIzena() {
        return kurtsoIzena;
    }

    public void setKurtsoIzena(String kurtsoIzena) {
        this.kurtsoIzena = kurtsoIzena;
    }

    public String getLokalidadea() {
        return lokalidadea;
    }

    public void setLokalidadea(String lokalidadea) {
        this.lokalidadea = lokalidadea;
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

    public String getModua() {
        return modua;
    }

    public void setModua(String modua) {
        this.modua = modua;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
}
