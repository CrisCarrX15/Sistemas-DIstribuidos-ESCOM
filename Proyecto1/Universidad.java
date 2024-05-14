import java.util.Scanner;

public class Universidad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int edad;
        char Genero;

        System.out.println("Ingrese su genero (H/M)");
        Genero = scan.next().charAt(0);
        System.out.println("Ingrse su edad");
        edad = scan.nextInt();
        // Extraer datod
        System.out.println("Edificio");

        if (Genero == 'H') {
            if (edad == 18)
                System.out.println("A");
            if (Genero == 'H')
                if (edad >= 19 && edad <= 22)
                    System.out.println("C");
            if (Genero == 'H')
                if (edad >= 23)
                    System.out.println("E1");
        }
        if (Genero == 'M') {
            if (edad == 18)
                System.out.println("B");
            if (Genero == 'M')
                if (edad >= 19 && edad <= 22)
                    System.out.println("D");
            if (Genero == 'M')
                if (edad >= 23)
                    System.out.println("E2");
        }
    }
}
