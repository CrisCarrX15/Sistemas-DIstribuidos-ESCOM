import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Impares {
    public static void main(String[] args) {
        String Entrada = "Entrada.txt";
        String Salida = "Salida.txt";
        int contador = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(Entrada));
            FileWriter writer = new FileWriter(Salida);

            String line = reader.readLine();
            while (line != null) {
                contador++; // Saber donde esta y que linea se quedo
                if (contador % 2 == 1) {
                    writer.write(line + "\n");
                }
                line = reader.readLine();
            }

            reader.close();
            writer.close();

            System.out.println("Archivo procesado ");
        } catch (IOException e) { // Por si no se encuentra el archivo
            System.out.println("No se pudo procesar el archivo " + e.getMessage());
        }
    }
}
