import java.util.Scanner;

public class Bidimensional {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arreglo[][], suma = 0;
        arreglo = new int[5][5];

        System.out.println("Ingrese los elementos de la matriz 5x5: ");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                arreglo[i][j] = scan.nextInt();

        System.out.println("\nArreglo bidimensional 5x5: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arreglo[i][j] + " ");
            }
            System.out.println("");
        }

        suma = arreglo[0][0] + arreglo[1][1] + arreglo[2][2] + arreglo[3][3] + arreglo[4][4];
        System.out.println("\nLa suma de la diagonal principal es: " + suma);
    }
}
