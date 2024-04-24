/**
 * Superclasse mare que engloba tots els productes
 */
public abstract class Producte {
    private double preu;
    private String nom, codiBarres;

    /**
     * Constructor de la superclasse producte
     * @param preu Preu del producte
     * @param nom Nom del producte
     * @param codiBarres Codi de barres del producte
     */
    public Producte(double preu, String nom, String codiBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiBarres = codiBarres;
    }

    //Setters i Getters
    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }
}
