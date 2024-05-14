import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Letra {
    public static void main(String[] args) throws IOException {
        String Entrada = "Entrada.txt";

        int contador = 0;
        String letras[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        BufferedReader reader = new BufferedReader(new FileReader(Entrada));

        String line = reader.readLine();
        for (int i = 0; i < letras.length; i++) {
            while ((line = reader.readLine()) != null) {

                if (line == letras[i]) {
                    contador++;

                }
            }
            System.out.println("Cantidad de veces que se encuentra una letra " + contador);
            reader.close();
        }

    }
}
