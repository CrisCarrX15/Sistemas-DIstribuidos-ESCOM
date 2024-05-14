/* Proyecto_3
 * Carrillo Soto Cristian Eduardo
 * 4CM13
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsultaVotos_Programa3 {
    public static void main(String[] args) {
        Map<String, Integer> partidos = new HashMap<>();
        Map<String, Integer> estados = new HashMap<>();
        Map<String, Integer> edades = new HashMap<>();
        int hombres = 0, mujeres = 0;
        String curp, sexo, estado;
        int edad;
        Scanner input = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("Curps.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                curp = line;
                sexo = curp.substring(10, 11);
                estado = curp.substring(11, 13);
                edad = 2023 - (1900 + Integer.parseInt(curp.substring(4, 6)));
                if (sexo.equals("H")) {
                    hombres++;
                } else {
                    mujeres++;
                }
                partidos.merge(curp.substring(16, 17), 1, Integer::sum);
                estados.merge(estado, 1, Integer::sum);
                edades.merge(Integer.toString(edad), 1, Integer::sum);
            }
        } catch (IOException e) {
            System.err.format("Error de E/S: %s%n", e);
            System.exit(1);
        }

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("¿Qué consulta desea realizar?\n" +
                    "1.- ¿Cuántos votos totales se han realizado por sexo?\n" +
                    "2.- ¿Cuántos votos totales se han realizado por cada estado de la república?\n" +
                    "3.- ¿Cuántos votos se han realizado por ciudadanos de x años de edad?\n" +
                    "4.- ¿Cuántos votos van por cada partido?\n" +
                    "0.- Salir\n");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Votos totales por sexo:");
                    System.out.println("Hombres: " + hombres);
                    System.out.println("Mujeres: " + mujeres + "\n");
                    break;
                case 2:
                    System.out.println("Votos totales por estado:");
                    for (Map.Entry<String, Integer> entry : estados.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese la edad que desea consultar:");
                    int edadConsulta = input.nextInt();
                    int votos = edades.getOrDefault(Integer.toString(edadConsulta), 0);
                    System.out.println("Votos realizados por ciudadanos de " + edadConsulta + " años: " + votos + "\n");
                    break;
                case 4:
                    System.out.println("Votos totales por partido:");
                    for (Map.Entry<String, Integer> entry : partidos.entrySet()) {
                        System.out.println("Partido " + entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.\n");
                    break;
            }
        }

        input.close();
    }
}
