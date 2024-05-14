import java.util.Scanner;

// Permite la entrada de datos
public class Fraccion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1;
        int num2;
        int den1;
        int den2;
        double resultado1, resultado2;
        double dec;
        System.out.println("Ingrese el numerador de la fraccion 1");
        num1 = scan.nextInt();
        System.out.println("Ingrese el denominador de la fraccion 1");
        den1 = scan.nextInt();
        System.out.println("Ingrese el numerador de la fraccion 2");
        num2 = scan.nextInt();
        System.out.println("Ingrese el denominador de la fraccion 2");
        den2 = scan.nextInt();

        resultado1 = num1 * num2;
        // Operacion1
        resultado2 = den1 * den2;
        // Operacion 2
        dec = resultado1 / resultado2;
        // Decimal
        System.out.println("El resultado es igual a " + resultado1 + "/" + resultado2);
        System.out.println("El resultado en decimal es igual a " + dec);

    }
}