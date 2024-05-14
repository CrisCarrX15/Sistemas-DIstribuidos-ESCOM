import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

public class PruebaPoligono {
    public static void main(String[] args) {
        int n = 10;
        int min = -100;
        int max = 100;

        PoligonoIrreg poligono = new PoligonoIrreg();
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < n; i++) {
            double aleatorioX = ThreadLocalRandom.current().nextDouble(min, max + 1);
            double aleatorioY = ThreadLocalRandom.current().nextDouble(min, max + 1);
            aleatorioX = Double.valueOf(df.format(aleatorioX));
            aleatorioY = Double.valueOf(df.format(aleatorioY));
            Coordenada vertice = new Coordenada(aleatorioX, aleatorioY);
            poligono.anadeVertice(vertice);
            System.out.println("Coordenada X: " + aleatorioX + " Coordenada Y: " + aleatorioY + " Magnitud: "
                    + Double.valueOf(df.format(poligono.Magnitud(vertice))));
        }

        System.out.println("\nVertices ordenados: ");
        poligono.ordena(poligono.vertices);

        System.out.println(poligono);
    }
}