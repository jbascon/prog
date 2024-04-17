public class Textil extends Producte{
    String composicioTextil;

    public Textil(float preu, String nom, int codiBarres, String composicioTextil) {
        super(preu, nom, codiBarres);
        this.composicioTextil = composicioTextil;
    }

    public String getComposicioTextil() {
        return composicioTextil;
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }
}
