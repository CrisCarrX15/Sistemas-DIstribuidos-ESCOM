public class Ejer5 {

    public static void main(String[] args) {

        char array[] = new char[3];
        int n = Integer.parseInt(args[0]);
        String cadenota[] = new String[n];
        int cont = 0;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < array.length; i++) {
                char letras = (char) (Math.random() * (90 - 65) + 65);
                array[i] = letras;
            }

            String cadena = String.valueOf(array[0]) + String.valueOf(array[1]) + String.valueOf(array[2]);
            // System.out.println(cadena);

            cadenota[k] = cadena;
        }

        for (int i = 0; i < cadenota.length; i++) {
            System.out.print(cadenota[i]);
            System.out.print(" ");

            if (cadenota[i] == "IPN") {
                cont++;
            }
        }
        System.out.print("\n");
        System.out.println("El numero de veces que encontró IPN es:" + cont);

    }
}