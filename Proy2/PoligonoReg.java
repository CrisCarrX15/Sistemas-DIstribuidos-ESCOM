import java.lang.Math;

public class PoligonoReg extends PoligonoIrreg {
    private static int numVertices;
    private static double angulo;

    public PoligonoReg(int numVertices) {
        super(numVertices);
        this.numVertices = numVertices;
        this.angulo = 2 * Math.PI / numVertices;
        this.calcularVertices();
    }

    public static void calcularVertices() {
        PoligonoIrreg poligono = new PoligonoIrreg(numVertices);

        for (int i = 0; i < numVertices; i++) {
            double x = Math.cos(i * angulo);
            double y = Math.sin(i * angulo);
            Coordenada c1 = new Coordenada(x, y);
            poligono.anadeVertice(c1);

        }
    }

    public static double calAreaPol(double[] lados) {
        int n = lados.length;
        double s = 0;
        for (double lado : lados) {
            s += lado;
        }
        s /= 2;

        double area = s;
        for (double lado : lados) {
            area *= (s - lado);
        }
        area = Math.sqrt(area);

        return area;
    }

}
