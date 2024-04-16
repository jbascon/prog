import java.util.Date;
import java.util.Scanner;

public class SaPaMercat {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int opcio;

        do {
            System.out.println("Benvingut al SaPaMercat");
            System.out.println("---------Inici---------");
            System.out.println("1. Introduir producte");
            System.out.println("2. Passar per caixa");
            System.out.println("3. Mostrar carret de compra");
            System.out.println("0. Acabar");
            System.out.print("Quina opció vols entrar: ");
            opcio = scan.nextInt();
        } while (opcio != 0);
    }

    public static class Alimentacio {
        float preu;
        String nom;
        int codiBarres;
        Date dataCaducitat = new Date();
    }

    public static class Textil {
        float preu;
        String nom, composicioTextil;
        int codiBarres;

    }

    public static class Electronica {
        float preu;
        String nom;
        int codiBarres, diesGarantia;

    }


}
