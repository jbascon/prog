public abstract class Producte {
    float preu;
    String nom;
    int codiBarres;


    public Producte(float preu, String nom, int codiBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiBarres = codiBarres;
    }


    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
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
