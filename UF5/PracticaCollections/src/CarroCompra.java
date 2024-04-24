import java.util.*;

public class CarroCompra {
    private List<Producte> productes;
    private Set<Alimentacio> aliments;
    private Set<Textil> textils;
    private Set<Electronica> electronics;

    public CarroCompra() {
        this.productes = new LinkedList<>();
        this.aliments = new HashSet<>();
        this.textils = new HashSet<>();
        this.electronics = new HashSet<>();


    }

    public void agregarProducte(Producte producte) {
        productes.add(producte);
        if (producte instanceof Alimentacio) {
            aliments.add((Alimentacio) producte);
        } else if (producte instanceof Textil) {
            textils.add((Textil) producte);
        } else if (producte instanceof Electronica) {
            electronics.add((Electronica) producte);
        }
    }

    public double calcularPrecioTotal() {
        return productes.stream().mapToDouble(Producte::getPreu).sum();
    }
}
