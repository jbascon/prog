import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe principal del supermercat
 */
public class SaPaMercat {
    static Scanner scan = new Scanner(System.in);

    /**
     * Classe main on s'obrirà el menú i escollirem les opcions del supermercat
     * @param args paràmetre obligatori en el main
     */
    public static void main(String[] args) throws IOException {
        int opcio, opcioProducte;
        CarroCompra carret = new CarroCompra();

        do {
            System.out.println("Benvingut al SaPaMercat");
            System.out.println("---------Inici---------");
            System.out.println("1. Introduir producte");
            System.out.println("2. Passar per caixa");
            System.out.println("3. Mostrar carret de compra");
            System.out.println("0. Acabar");
            System.out.print("Quina opció vols entrar: ");
            opcio = scan.nextInt();
            System.out.println();

            switch (opcio) {
                case 1 -> {
                    do {
                        System.out.println("---Producte---");
                        System.out.println("1. Alimentació");
                        System.out.println("2. Tèxtil");
                        System.out.println("3. Electrònica");
                        System.out.println("0. Tornar");
                        System.out.print("Quin producte vols entrar: ");
                        opcioProducte = scan.nextInt();
                        scan.nextLine();
                        System.out.println();

                        switch (opcioProducte) {
                            case 1 -> {
                                System.out.println("Afegir aliment");
                                System.out.print("Nom: ");
                                String nomAliment = scan.nextLine();
                                System.out.print("Preu: ");
                                double preuAliment = scan.nextDouble();
                                scan.nextLine();
                                System.out.print("Data de Caducitat: ");
                                String dataCaducitatString = scan.nextLine();
                                System.out.print("Codi de Barres: ");
                                String codiAliment = scan.nextLine();
                                Date dataCaducitat = convertirDate(dataCaducitatString);
                                Alimentacio nouAliment = new Alimentacio(preuAliment, nomAliment, codiAliment, dataCaducitat);
                                carret.agregarProducte(nouAliment);
                                System.out.println("Aliment agregat al carret correctament.");
                            }
                            case 2 -> {
                                System.out.println("Afegir tèxtil");
                                System.out.print("Nom: ");
                                String nomTextil = scan.nextLine();
                                System.out.print("Preu: ");
                                double preuTextil = scan.nextDouble();
                                scan.nextLine();
                                System.out.print("Composició Tèxtil: ");
                                String composicio = scan.nextLine();
                                System.out.print("Codi de Barres: ");
                                String codiTextil = scan.nextLine();
                                Textil nouTextil = new Textil(preuTextil, nomTextil, codiTextil, composicio);
                                carret.agregarProducte(nouTextil);
                                System.out.println("Tèxtil agregat al carret correctament.");
                            }
                            case 3 -> {
                                System.out.println("Afegir electrònic");
                                System.out.print("Nom: ");
                                String nomElectronic = scan.nextLine();
                                System.out.print("Preu: ");
                                double preuElectronic = scan.nextDouble();
                                scan.nextLine();
                                System.out.print("Dies de Garantia: ");
                                int diesGarantia = scan.nextInt();
                                scan.nextLine();
                                System.out.print("Codi de Barres: ");
                                String codiElectronic = scan.nextLine();
                                Electronica nouElectronic = new Electronica(preuElectronic, nomElectronic, codiElectronic, diesGarantia);
                                carret.agregarProducte(nouElectronic);
                                System.out.println("Electrònic agregat al carret correctament.");
                            }
                            case 0 -> {
                            }
                        }
                    } while (opcioProducte != 0);
                }
                case 2 -> {
                    carret.actualitzarPreus();
                    carret.passarTicketCompra();
                }
                case 3 -> {
                    carret.mostrarCarret();
                    System.out.println();
                }
                case 4 -> {
                }
            }
        } while (opcio != 0);
    }

    /**
     * Funció que converteix de String a Date la data de caducitat dels productes d'alimentació.
     * @param data data d'entrada que entrem al producte d'alimentació
     * @return retorna la data que hem entrat a Date per poder-lo afegir al carret
     */
    private static Date convertirDate(String data) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return format.parse(data);
        } catch (ParseException e) {
            System.out.println("No s'ha pogut convertir la data per un error de parsejat.");
            e.printStackTrace();
            return null;
        }
    }
}
