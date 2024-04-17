import java.time.LocalDate;

public class Alimentacio extends Producte{
    LocalDate dataCaducitat;

    public Alimentacio(float preu, String nom, int codiBarres, LocalDate dataCaducitat) {
        super(preu, nom, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }


    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }
}
