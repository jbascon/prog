import java.io.*;
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
        if (producte.getNom().length() > 15) {
            throw new IllegalArgumentException("El nom del producte és massa llarg");
        } else {
            productes.add(producte);
            String codiBarres = producte.getCodiBarres();
            mapProductes.put(codiBarres, mapProductes.getOrDefault(codiBarres, 0) + 1);
        }
    }

    public void actualitzarPreus() throws IOException {
        try {
            File f = new File("./updates/UpdateTextilPrices.dat");
            if (f.exists()) {
                procesarArchivoUpdateTextil(f);
            }
        } catch (IOException e) {
            registrarException(e);
        } catch (Exception e) {
            registrarException(e);
        }
    }

    public void registrarException(Exception e) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./logs/Exceptions.dat", true))) {
            writer.println("Data: " + new Date());
            writer.println("Missatge: " + e.getMessage());
            writer.println("Tipus: " + e.getClass().getName());
            writer.println("Stack Trace:");
            e.printStackTrace(writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void procesarArchivoUpdateTextil(File archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linia;
            while ((linia = reader.readLine()) != null) {

                String[] parts = linia.split(",");


                if (parts.length == 2) {
                    String codiBarres = parts[0].trim();
                    double nouPreu = Double.parseDouble(parts[1].trim());

                    Optional<Producte> producteOptional = trobarProducte(codiBarres);
                    if (producteOptional.isPresent()) {
                        Producte producte = producteOptional.get();

                        if (producte instanceof Textil) {
                            Textil textil = (Textil) producte;
                            textil.setPreu(nouPreu);
                            System.out.println("Preu del tèxtil amb codi de barres " + codiBarres + " actualitzat a " + nouPreu + ".");
                        } else {
                            System.out.println("El producte amb codi de barres " + codiBarres + " no és un producte tèxtil.");
                        }
                    } else {
                        System.out.println("No s'ha trobat cap producte amb el codi de barres " + codiBarres + ".");
                    }
                }
            }
        }
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
