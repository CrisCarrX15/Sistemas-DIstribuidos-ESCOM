import java.util.Scanner;

public class Vacaciones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int años, dias, dias2;

        System.out.println("Ingrese los años que a trbajado en la empresa");
        años = scan.nextInt();
        System.out.println("Sus dias de vacaciones son:");
        if (años >= 1 && años <= 5)
            System.out.println("5");
        else if (años >= 6 && años <= 10)
            System.out.println("10");
        else if (años >= 11 && años <= 19) {
            dias = años;
            System.out.println(dias);
        } else if (años >= 20 && años <= 40) {
            dias2 = años + 2;
            System.out.println(dias2);
        }

    }

}
