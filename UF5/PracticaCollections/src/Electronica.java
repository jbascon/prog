public class Electronica extends Producte{
    private int diesGarantia;

    public Electronica(double preu, String nom, int codiBarres, int diesGarantia) {
        super(preu, nom, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double getPreu() {
        return super.getPreu() + super.getPreu() * (diesGarantia / 365.0) * 0.1;
    }
}
