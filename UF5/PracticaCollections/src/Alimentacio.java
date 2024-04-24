import java.util.Date;

/**
 * Classe per guardar aliments, filla de Producte
 */
public class Alimentacio extends Producte{
    private Date dataCaducitat;

    /**
     * Constructor de la classe Alimentació
     * @param preu Preu de l'aliment
     * @param nom Nom de l'aliment
     * @param codiBarres Codi de barres de l'aliment
     * @param dataCaducitat Data de caducitat de l'aliment
     */
    public Alimentacio(double preu, String nom, String codiBarres, Date dataCaducitat) {
        super(preu, nom, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    //Setters i Getters
    public Date getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(Date dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * Funció que calcula el descompte segons la data de caducitat
     * @return Retorna el preu amb el descompte
     */
    @Override
    public double getPreu() {
        Date dataActual = new Date();
        long diesRestants = (dataCaducitat.getTime() - dataActual.getTime()) / (1000 * 60 * 60 * 24) + 1;
        return super.getPreu() - super.getPreu() * (1.0 /diesRestants) + (super.getPreu() * 0.1);
    }
}
