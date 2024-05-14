import java.util.Scanner;

// Permite la entrada de datos
public class Grados {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner grados = new Scanner(System.in);
        // Sirve para la entrada de los datos en este caso los grados
        double gradosC, gradosF;
        System.out.println("Ingrese los grados Celcius");
        gradosC = grados.nextDouble();
        // Agarra los datos que estan dentos de la variable de Gradosc
        gradosF = (gradosC * 9 / 5) + 32;
        // A partir de los datos en los gradosC se hara la conversion a Farenheit
        System.out.println(" Los grados Celcius " + gradosC + " es igual a " + gradosF + " grados Farenheit");
    }
}