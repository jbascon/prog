public abstract class Producte {
    private double preu;
    private String nom;
    private int codiBarres;


    public Producte(double preu, String nom, int codiBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiBarres = codiBarres;
    }


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

    public int getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(int codiBarres) {
        this.codiBarres = codiBarres;
    }
}
