import java.util.Scanner;

public class Posicion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arreglo[], ultimo;
        arreglo = new int[10];

        System.out.println("Ingrese 10 números en el arreglo");
        for (int i = 0; i < arreglo.length; i++)
            arreglo[i] = scan.nextInt();

        ultimo = arreglo[arreglo.length - 1];
        for (int p = arreglo.length - 1; p > 0; p--)
            arreglo[p] = arreglo[p - 1];

        arreglo[0] = ultimo;

        System.out.println("Desplazando...s");
        for (int j = 0; j < arreglo.length; j++)
            System.out.print(arreglo[j] + " ");
    }
}
