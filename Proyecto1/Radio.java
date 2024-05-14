import java.util.Scanner;

public class Radio {

    public static void main(String[] args) {
        Scanner area = new Scanner(System.in);
        Scanner per = new Scanner(System.in);
        // Sirve para la entrada de los datos
        double a, p;
        double r;
        System.out.println("Ingrese el area del triangulo");
        a = area.nextDouble();
        System.out.println("Ingrese el perimetro del triangulo");
        p = per.nextDouble();
        r = (a * 2) / p;
        // Formula de radio
        System.out.println("El radio de la circuferencias es " + r);
    }
}
