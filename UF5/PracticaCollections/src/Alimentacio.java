import java.util.Date;

public class Alimentacio extends Producte{
    private Date dataCaducitat;

    public Alimentacio(double preu, String nom, String codiBarres, Date dataCaducitat) {
        super(preu, nom, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }


    public Date getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(Date dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double getPreu() {
        Date dataActual = new Date();
        long diesRestants = (dataCaducitat.getTime() - dataActual.getTime()) / (1000 * 60 * 60 * 24) + 1;
        return super.getPreu() - super.getPreu() * (1.0 /diesRestants) + (super.getPreu() * 0.1);
    }
}
