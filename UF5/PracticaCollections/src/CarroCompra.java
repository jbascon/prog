import java.util.*;

/**
 * Classe per guardar els productes dins un "Carret de la compra"
 */
public class CarroCompra {
    final private List<Producte> productes;
    final private Map<String, Producte> mapProductes;

    /**
     * Constructor de la classe CarroCompra
     */
    public CarroCompra() {
        this.productes = new ArrayList<>();
        this.mapProductes = new HashMap<>();
    }

    /**
     * Funció que permet guardar un producte en un ArrayList (carret)
     * @param producte Producte introduït
     */
    public void agregarProducte(Producte producte) {
        productes.add(producte);
        mapProductes.put(producte.getCodiBarres(), producte);
    }

    /**
     * Funció que calcula el preu total sumat de tots els productes
     * @return retorna la suma total de tots els productes
     */
    public double calcularPreuTotal() {
        return productes.stream().mapToDouble(Producte::getPreu).sum();
    }

    public String trobarProducte(String codiBarres) {
        if (mapProductes.containsKey(codiBarres)) {
            return mapProductes.get(codiBarres).getNom();
        } else {
            return "Producte no trobat";
        }
    }
}
