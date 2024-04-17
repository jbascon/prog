import java.time.LocalDate;
import java.util.Scanner;

public class SaPaMercat {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int opcio, opcioProducte;

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
                case 1:
                    do {
                        System.out.println("---Producte---");
                        System.out.println("1. Alimentació");
                        System.out.println("2. Tèxtil");
                        System.out.println("3. Electrònica");
                        System.out.println("0. Tornar");
                        System.out.print("Quin producte vols entrar: ");
                        opcioProducte = scan.nextInt();
                        System.out.println();

                        switch (opcioProducte) {

                        }
                    } while (opcioProducte != 0);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (opcio != 0);
    }


}
