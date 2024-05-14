/*
    Proyecto 2 Segunda Parte
    Méndez Castañeda Aurora
    Grupo: 4CM14
*/
import java.io.*;
import java.util.*;

public class DetectarPalindromos {
    public static void main(String[] args) throws FileNotFoundException {
		
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);   
        ArrayList<String> palabras = new ArrayList<>();

        String palabra;

        while(sc.hasNext()){ 
            //quitamos signos de puntuación
            palabra = sc.next().replaceAll("[¡!\"#$%&'()*+,-./:;<=>¿?@\\[\\]^_`{|}~—«»0-9]", "").toLowerCase();
            //quitamos tildes
            palabra = palabra.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
            .replace("ú", "u");
            //agregamos al arraylist
            palabras.add(palabra);
        }

        //System.out.println(palabras);
        //generamos los posibles palindromos de 2 a n palabras
        String palabra1, palabra2, cadena, cadenaAux;
        char letraInicial, letraFinal;
        int np = 0;
        
        System.out.println("Palindromos: ");

        for(int i=0; i<palabras.size(); i++){
            cadena = "";
            cadenaAux = "";
            palabra1 = palabras.get(i);
            letraInicial = palabra1.charAt(0);
            cadena += palabra1;
            cadenaAux += palabra1;
            for(int j=i+1; j< palabras.size(); j++){    
                palabra2 = palabras.get(j);
                letraFinal = palabra2.charAt(palabra2.length()-1);
                cadena += palabra2;
                cadenaAux += " " + palabra2;
                
                if(letraInicial == letraFinal){
                    if(esPalindromo(cadena)){
                        np++;
                        System.out.println(np +". " + cadenaAux);
                    }
                }
            }
        }
	}

    public static boolean esPalindromo(String cadena) {
		String invertida = new StringBuilder(cadena).reverse().toString();
		return invertida.equals(cadena);
	}
}
