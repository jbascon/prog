public class Electronica extends Producte{
    int diesGarantia;

    public Electronica(float preu, String nom, int codiBarres, int diesGarantia) {
        super(preu, nom, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }
}
