import java.util.Scanner;

public class Luz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int con, kW;

        System.out.println("Cuenta con contrato de...");
        System.out.println(" Hogar");
        System.out.println(" Negocio");
        con = scan.nextInt();
        System.out.print("Ingrese los kW consumidos: ");
        kW = scan.nextInt();

        switch (con) {
            case 1 -> {
                System.out.println("Total a pagar $" + calculaTPagar(kW));
            }
            case 2 -> {
                System.out.println("Total a pagar $" + kW * 5);
            }
        }
    }

    public static double calculaTPagar(int kW) {
        double costoTotal = 0;

        if (kW > 250) {
            costoTotal = 250 * 0.65;
            kW -= 250;
            if (kW > 250) {
                costoTotal += 250 * 0.85;
                kW -= 250;
                if (kW > 250) {
                    costoTotal += 250 * 1.50;
                    kW -= 250;
                    if (kW > 250) {
                        costoTotal += 250 * 2.50;
                        kW -= 250;
                        if (kW > 250) {
                            costoTotal += 250 * 3.00;
                        } else {
                            costoTotal += kW * 3.00;

                        }
                    } else {
                        costoTotal += kW * 2.50;

                    }
                } else {
                    costoTotal += kW * 1.50;

                }
            } else {
                costoTotal += kW * 0.85;

            }
        } else {
            costoTotal += kW * 0.65;

        }
        return costoTotal;

    }

}
