/* Proyecto_3
 * Carrillo Soto Cristian Eduardo
 * 4CM13
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EstadisticasVotacion_Programa2 {

    // Método que retorna una cadena con asteriscos cada "n" votos
    public static String cadenaConAsteriscos(int votos, int n) {
        String cadena = "";
        for (int i = 1; i <= votos; i++) {
            if (i % n == 0) {
                cadena += "*";
            }
        }
        return cadena;
    }

    public static void main(String[] args) {
        try {
            // Mapa para almacenar el número de votos por partido
            Map<String, Integer> votosPartidos = new HashMap<>();
            votosPartidos.put("Partido 1", 0);
            votosPartidos.put("Partido 2", 0);
            votosPartidos.put("Partido 3", 0);
            votosPartidos.put("Partido 4", 0);

            // Bucle infinito para imprimir las estadísticas cada 3 segundos
            while (true) {
                // Limpiar pantalla
                ProcessBuilder processBuilder = new ProcessBuilder("clear");
                processBuilder.inheritIO();
                processBuilder.start().waitFor();

                // Leer el archivo de votaciones
                BufferedReader reader = new BufferedReader(new FileReader("Curps.txt"));
                String line = reader.readLine();
                while (line != null) {
                    // Contar los votos por partido
                    if (line.contains("Partido 1")) {
                        votosPartidos.put("Partido 1", votosPartidos.get("Partido 1") + 1);
                    } else if (line.contains("Partido 2")) {
                        votosPartidos.put("Partido 2", votosPartidos.get("Partido 2") + 1);
                    } else if (line.contains("Partido 3")) {
                        votosPartidos.put("Partido 3", votosPartidos.get("Partido 3") + 1);
                    } else if (line.contains("Partido 4")) {
                        votosPartidos.put("Partido 4", votosPartidos.get("Partido 4") + 1);
                    }

                    line = reader.readLine();
                }
                reader.close();

                // Imprimir las estadísticas de los votos con asteriscos cada 5 votos
                System.out.println("Estadísticas de votaciones:");
                for (String partido : votosPartidos.keySet()) {
                    int numVotos = votosPartidos.get(partido);
                    String cadenaAsteriscos = cadenaConAsteriscos(numVotos, 5);
                    System.out.println(partido + ": " + numVotos + " " + cadenaAsteriscos);
                }
                System.out.println();

                // Esperar 3 segundos
                Thread.sleep(3000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
