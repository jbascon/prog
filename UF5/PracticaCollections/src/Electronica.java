/**
 * Classe per guardar Electrònics, filla de Producte
 */
public class Electronica extends Producte{
    private int diesGarantia;

    /**
     * Constructor de la classe Electronica
     * @param preu Preu de l'electrònic
     * @param nom Nom de l'electrònic
     * @param codiBarres Codi de barres de l'electrònic
     * @param diesGarantia Dies de garantia de l'elèctronic
     */
    public Electronica(double preu, String nom, String codiBarres, int diesGarantia) {
        super(preu, nom, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    //Setters i Getters
    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    /**
     * Override del getPreu per calcular el preu real comptant els dies de garantia
     * @return Retorna el preu real
     */
    @Override
    public double getPreu() {
        return super.getPreu() + super.getPreu() * (diesGarantia / 365.0) * 0.1;
    }
}
