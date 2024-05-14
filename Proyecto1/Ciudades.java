import java.util.Scanner;

public class Ciudades {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String arreglo[] = new String[10];
        String comparador;

        System.out.println("Ingrese el nombre de 10 cuidades ");
        for (int i = 0; i < arreglo.length; i++)
            arreglo[i] = scan.nextLine();
        comparador = arreglo[0];
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].length() > comparador.length()) {
                comparador = arreglo[i];
                System.out.println("La ciudad con el nombre mas largo es: " + comparador);
            }
        }
    }
}
