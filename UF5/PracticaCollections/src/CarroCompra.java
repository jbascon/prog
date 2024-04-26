import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Classe per guardar els productes dins un "Carret de la compra"
 */
public class CarroCompra {
    final private List<Producte> productes;
    final private Map<String, Integer> mapProductes;

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
        String codiBarres = producte.getCodiBarres();
        mapProductes.put(codiBarres, mapProductes.getOrDefault(codiBarres, 0) + 1);
    }

    public void passarTicketCompra() {
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataActual = sdf.format(todayDate);

        System.out.println("---------------------");
        System.out.println("SaPaMercat");
        System.out.println("---------------------");
        System.out.println("Data: " + dataActual);
        System.out.println("---------------------");

        for (Producte producte : productes) {
            String codiBarres = producte.getCodiBarres();
            mapProductes.put(codiBarres, mapProductes.getOrDefault(codiBarres, 0) + 1);
        }

        double ticketTotal = 0.0;
        for (Map.Entry<String, Integer> entry : mapProductes.entrySet()) {
            String codiBarres = entry.getKey();
            int quantitat = entry.getValue();
            Producte producte = trobarProducte(codiBarres).get();
            double preuUnitari = producte.getPreu();
            double preuTotal = preuUnitari * quantitat;
            System.out.println("Nom: " +  producte.getNom() + " Quantitat: "+ quantitat + " Preu Total: " + preuTotal);
            ticketTotal += preuTotal;
        }

        System.out.println("---------------------");
        System.out.println("Total: " + ticketTotal);

        buidarCarret();
    }

    public void mostrarCarret() {
        System.out.println("Carret: ");

        for (Producte producte : productes) {
            String nom = producte.getNom();
            String codiBarres = producte.getCodiBarres();
            int quantitat = mapProductes.get(codiBarres);
            System.out.println(nom + " -> " + quantitat);
        }
    }


    /**
     * Funció que troba un producte a través del codi de barres
     *
     * @param codiBarres Codi de barres d'un producte
     * @return Retorna el nom del producte trobat gràcies al codi de barres
     */
    public Optional<Producte> trobarProducte(String codiBarres) {
        for (Producte producte : productes) {
            if (producte.getCodiBarres().equals(codiBarres)) {
                return Optional.of(producte);
            }
        }
        return Optional.empty();
    }

    public void buidarCarret() {
        productes.clear();
    }

}
