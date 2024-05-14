/* Proyecto_3
 * Carrillo Soto Cristian Eduardo
 * 4CM13
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GeneraCurps_Programa1 {

    private static final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SEXO = "HM";
    private static final String[] ENTIDADES = { "AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR",
            "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ",
            "YN", "ZS" };
    private static final String[] PARTIDOS = { "Partido 1", "Partido 2", "Partido 3", "Partido 4" };
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java GeneradorCurps <registrosPorSegundo>");
            System.exit(1);
        }
        int registrosPorSegundo = Integer.parseInt(args[0]);
        try {
            FileWriter writer = new FileWriter("Curps.txt");
            while (true) {
                String curp = generarCurp();
                int partidoIndex = RANDOM.nextInt(PARTIDOS.length);
                String partido = PARTIDOS[partidoIndex];
                writer.write(curp + " - " + partido + "\n");
                writer.flush();
                Thread.sleep(1000 / registrosPorSegundo);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String generarCurp() {
        StringBuilder sb = new StringBuilder(18);
        for (int i = 1; i < 5; i++) {
            int indice = RANDOM.nextInt(LETRAS.length());
            sb.append(LETRAS.charAt(indice));
        }
        for (int i = 5; i < 11; i++) {
            int indice = RANDOM.nextInt(NUMEROS.length());
            sb.append(NUMEROS.charAt(indice));
        }
        int indice = RANDOM.nextInt(SEXO.length());
        sb.append(SEXO.charAt(indice));
        sb.append(ENTIDADES[RANDOM.nextInt(32)]);
        for (int i = 14; i < 17; i++) {
            indice = RANDOM.nextInt(LETRAS.length());
            sb.append(LETRAS.charAt(indice));
        }
        for (int i = 17; i < 19; i++) {
            indice = RANDOM.nextInt(NUMEROS.length());
            sb.append(NUMEROS.charAt(indice));
        }
        return sb.toString();
    }
}
