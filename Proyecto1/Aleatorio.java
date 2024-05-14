import java.util.Scanner;

public class Aleatorio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num;
        int i = 1;
        int x = 1;

        num = (int) (Math.random() * 100 + 1);

        System.out.println("Adivine el número entre 1 a 100 (introduzca 0 para salir)");

        while (x != num && x != 0) {
            System.out.print("Intento " + i + ": ");
            x = scan.nextInt();
            i++;

            if (x > num)
                System.out.println("Te pasaste, es menor");
            else if (x < num)
                System.out.println("Un poco mas, es mayor");
            else
                System.out.println("Felicidades !! El número era: " + num);
        }
    }

}
