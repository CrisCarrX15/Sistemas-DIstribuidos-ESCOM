import java.util.Scanner;

public class Cubo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ultimo, aux;
        int sumaCubo = 0;

        for (int i = 1; i <= 5000; i++) {
            sumaCubo = 0;
            aux = i;

            for (int j = 0; j < 3; j++) {
                ultimo = aux % 10;
                sumaCubo += (ultimo * ultimo * ultimo);
                aux /= 10;
            }

            if (sumaCubo == i)
                System.out.println(i + " = suma del cubo de sus dígitos");
        }
    }

}
