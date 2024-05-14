import java.util.Scanner;

public class Desendente {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arreglo[];
        arreglo = new int[10];
        int comparador;

        System.out.println("Ingrese 10 numeros");
        for (int i = 0; i < arreglo.length; i++)
            arreglo[i] = scan.nextInt();
        comparador = arreglo[0];
        for (int i = 0; i < arreglo.length; i++)
            if (arreglo[i] >= comparador) {
                comparador = arreglo[i];
                System.out.println("El arreglo es decendente");
            } else {
                System.out.println("El arreglo no es decendente");
            }

    }

}
