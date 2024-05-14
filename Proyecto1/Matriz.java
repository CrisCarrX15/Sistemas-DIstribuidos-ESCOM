import java.util.Scanner;

public class Matriz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;

        System.out.println("Escribe el tamaño de las 2 matrices");
        n = scan.nextInt();
        int matriz1[][] = new int[n][n];
        int matriz2[][] = new int[n][n];

        int resultado[][] = new int[n][n];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {

                System.out.println("Escribe el valor para la fila " + i + " y columna " + j + " de la matriz 1");
                matriz1[i][j] = scan.nextInt();
                System.out.println("Escribe el valor para la fila " + i + " y columna " + j + " de la matriz 2");
                matriz2[i][j] = scan.nextInt();

            }
        }

        System.out.println("\nMultiplicación de matrices");
        resultado = multiplicarMatrices(matriz1, matriz2);

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static int[][] multiplicarMatrices(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];

        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return c;
    }
}
