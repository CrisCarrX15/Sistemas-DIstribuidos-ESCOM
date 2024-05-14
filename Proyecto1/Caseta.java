import java.util.Scanner;

public class Caseta {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eje, ejeadd;
        int extra = 50;

        System.out.println("Ingrese el numero de ejes");
        eje = scan.nextInt();
        if (eje == 1)
            System.out.println("Paguen $20");
        else if (eje == 2)
            System.out.println("Pague $40");
        else if (eje == 3)
            System.out.println("Pague $60");
        else if (eje >= 4 && eje <= 6)
            System.out.println("Pague $250");
        else if (eje >= 7) {
            ejeadd = 250 + extra * (eje - 6);
            System.out.println("Pague $ " + ejeadd);
        }
    }

}
