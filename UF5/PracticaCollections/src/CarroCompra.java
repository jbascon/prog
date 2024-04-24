import java.util.*;

/**
 * Classe per guardar els productes dins un "Carret de la compra"
 */
public class CarroCompra {
    final private List<Producte> productes;
    final private Map<String, Producte> mapProductes;
    final private Map<String, Integer> mapQuantitat;

    /**
     * Constructor de la classe CarroCompra
     */
    public CarroCompra() {
        this.productes = new ArrayList<>();
        this.mapProductes = new HashMap<>();
        this.mapQuantitat = new HashMap<>();
    }

    /**
     * Funció que permet guardar un producte en un ArrayList (carret)
     * @param producte Producte introduït
     */
    public void agregarProducte(Producte producte) {
        productes.add(producte);
        String codiBarres = producte.getCodiBarres();
        mapQuantitat.put(codiBarres, mapQuantitat.getOrDefault(codiBarres, 0) + 1);
    }

    public void mostrarCarret() {
        System.out.println("Carret: ");

        for (Producte producte : productes) {
            String nom = producte.getNom();
            String codiBarres = producte.getCodiBarres();
            int quantitat = mapQuantitat.get(codiBarres);
            System.out.println(nom + " -> " + quantitat );
        }
    }

    /**
     * Funció que calcula el preu total sumat de tots els productes
     * @return retorna la suma total de tots els productes
     */
    public double calcularPreuTotal() {
        return productes.stream().mapToDouble(Producte::getPreu).sum();
    }

    /**
     * Funció que troba un producte a través del codi de barres
     * @param codiBarres Codi de barres d'un producte
     * @return Retorna el nom del producte trobat gràcies al codi de barres
     */
    public String trobarProducte(String codiBarres) {
        if (mapProductes.containsKey(codiBarres)) {
            return mapProductes.get(codiBarres).getNom();
        } else {
            return "Producte no trobat";
        }
    }
}
