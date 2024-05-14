import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arreglo[];
        arreglo = new int[10];

        System.out.println("Ingrese 10 números enteros:");
        for (int i = 0; i < arreglo.length; i++)
            arreglo[i] = scan.nextInt();

        System.out.println("Los números ingresados son:");
        for (int j = 0; j < arreglo.length; j++)
            System.out.println(arreglo[j]);
    }

}
