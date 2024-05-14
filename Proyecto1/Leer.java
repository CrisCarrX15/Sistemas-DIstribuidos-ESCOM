import java.util.Scanner;

public class Leer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = 1;
        double x = 0;
        double suma = 0, promedio = 0;
        while (num != 0) {
            System.out.println("Escriba un numero distinto a 0");
            num = scan.nextInt();
            if (num != 0) {
                suma = suma + num;
                x = x + 1;
                promedio = suma / x;

            }

        }

        System.out.println("El promedio es igual a " + promedio);

    }

}
