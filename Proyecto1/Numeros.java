import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c;
        System.out.println("Ingrese el primer numero");
        a = scan.nextInt();
        System.out.println("Ingrese el segundo numero");
        b = scan.nextInt();
        System.out.println("Ingrese el tercer numero");
        c = scan.nextInt();
        System.out.println("El primer valor seria");
        if (a >= b && a >= c) {
            System.out.println(a);
            if (a <= b && a >= c)
                System.out.println(b);
            if (a <= c && a >= b)
                System.out.println(c);
        }
        System.out.println("El segundo valor seria");
        if (b >= a && b >= c) {
            System.out.println(b);
            if (b <= a && b >= c)
                System.out.println(a);
            if (b <= c && b >= a)
                System.out.println(c);
        }
        System.out.println("El tercer valor seria");
        if (c >= b && c >= a) {
            System.out.println(c);
            if (c <= b && c >= a)
                System.out.println(b);
            if (c <= a && c >= b)
                System.out.println(a);
        }

    }

}
