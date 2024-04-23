public class Textil extends Producte implements Comparable<Textil>{
    private String composicioTextil;

    public Textil(double preu, String nom, int codiBarres, String composicioTextil) {
        super(preu, nom, codiBarres);
        this.composicioTextil = composicioTextil;
    }

    public String getComposicioTextil() {
        return composicioTextil;
    }
    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

    @Override
    public int compareTo(Textil altreTextil) {
        return this.composicioTextil.compareTo(altreTextil.getComposicioTextil());
    }
}
