import java.util.Scanner;

public class Entero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        int suma = 0;
        int aux = 0;

        System.out.println("Ingrese un número entero: ");
        num = scan.nextInt();
        for (int i = 1; i <= num; i++) {
            suma = num + i;
            aux = suma + num;
        }
        System.out.println(aux);

    }

}
