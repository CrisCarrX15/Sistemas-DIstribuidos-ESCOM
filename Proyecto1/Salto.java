import java.util.Scanner;

public class Salto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x, y;
        System.out.println("Ingrese un número x: ");
        x = scan.nextInt();
        System.out.println("Ingrese un número y: ");
        y = scan.nextInt();
        while (x < 200) {
            System.out.print(x + ", ");
            x = x + y;
        }
    }
}
