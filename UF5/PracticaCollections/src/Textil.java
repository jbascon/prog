/**
 * Classe per guardar tèxtils, filla de Producte
 */
public class Textil extends Producte implements Comparable<Textil>{
    private String composicioTextil;

    /**
     * Constructor de la classe Textil
     * @param preu Preu del tèxtil
     * @param nom Nom del tèxtil
     * @param codiBarres Codi de barres del tèxtil
     * @param composicioTextil Composició del tèxtil
     */
    public Textil(double preu, String nom, String codiBarres, String composicioTextil) {
        super(preu, nom, codiBarres);
        this.composicioTextil = composicioTextil;
    }

    //Setters i Getters
    public String getComposicioTextil() {
        return composicioTextil;
    }
    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

    /**
     * compareTo per comparar si dos productes tèxtils són iguals
     * @param altreTextil the object to be compared.
     * @return retorna
     */
    @Override
    public int compareTo(Textil altreTextil) {
        return this.composicioTextil.compareTo(altreTextil.getComposicioTextil());
    }
}
