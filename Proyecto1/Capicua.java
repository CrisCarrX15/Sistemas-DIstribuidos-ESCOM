import java.util.Scanner;

public class Capicua {
    public static void main(String[] args) {
        int num, cifra, aux;
        int inverso = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa un numero entre 0 y 9999 ");
        num = scan.nextInt();

        switch (num) {

            case 1 -> {
                aux = num;
                if (aux >= 0 && aux <= 9) {
                    cifra = aux % 1;
                    inverso = inverso * 1 + cifra;
                    aux = aux / 1;
                }

            }

            case 2 -> {
                aux = num;
                if (aux >= 10 && aux <= 99) {
                    cifra = aux % 10;
                    inverso = inverso * 10 + cifra;
                    aux = aux / 10;
                }

            }
            case 3 -> {
                aux = num;
                if (aux >= 100 && aux <= 999) {
                    cifra = aux % 100;
                    inverso = inverso * 100 + cifra;
                    aux = aux  / 100;
                }

            }
            case 4 -> {
                aux = num;
                if (aux >= 1000 && aux <= 9999) {
                    cifra = aux % 1000;
                    inverso = inverso * 1000 + cifra;
                    aux = aux / 1000;
                }

            }

        }
        if (num == inverso) {
            System.out.println("Es capicua");
        } else {
            System.out.println("No es capicua");
        }

    }

}
