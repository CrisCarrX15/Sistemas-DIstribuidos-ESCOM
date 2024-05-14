import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class PruebaPoligono {
    public static void main(String[] args) {
        int n = 10;
        int min = -10;
        int max = 10;
        PoligonoIrreg poligono = new PoligonoIrreg(n);
        for (int i = 0; i < n; i++) {
            PoligonoReg.calcularVertices();
            /*
             * int aleatorioX = ThreadLocalRandom.current().nextInt(min, max + 1);
             * int aleatorioY = ThreadLocalRandom.current().nextInt(min, max + 1);
             * System.out.println("Coordenada X: " + aleatorioX + " Coordenada Y: " +
             * aleatorioY);
             * poligono.anadeVertice(new Coordenada(aleatorioX, aleatorioY));
             */}

        System.out.println(poligono);
    }
}