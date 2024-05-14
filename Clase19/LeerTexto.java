import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeerTexto {

    public static void main(String[] args) {
        String fileName = "El_viejo_y_el_mar.txt";
        Map<Character, Integer> charCountMap = new HashMap<>();
        ArrayList<Map> i = new ArrayList<>(null); 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = br.read()) != -1) {
                char character = (char) c;
                if (charCountMap.containsKey(character)) {
                    int count = charCountMap.get(character);
                    charCountMap.put(character, count + 1);
                } else {
                    charCountMap.put(character, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Número de caracteres distintos encontrados: " + charCountMap.size());
        System.out.println("Mapa de caracteres distintos y sus ocurrencias:");
        System.out.println(charCountMap);
    }
}