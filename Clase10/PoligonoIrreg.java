import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.text.DecimalFormat;

public class PoligonoIrreg {
    protected List<Coordenada> vertices;
    private int numVertices;

    public PoligonoIrreg() {
        vertices = new ArrayList<Coordenada>();
        numVertices = -1;
    }

    public void anadeVertice(Coordenada vertice) {
        if (numVertices < vertices.size()) {
            vertices.add(vertice);
            numVertices++;
        }
    }

    public double Magnitud(Coordenada vertice) {
        double x = vertice.abcisa();
        double y = vertice.ordenada();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    class ordenaVertice implements Comparator<Coordenada> {

        public int compare(Coordenada c1, Coordenada c2) {
            if (Magnitud(c1) < Magnitud(c2))
                return -1;
            else if (Magnitud(c1) > Magnitud(c2))
                return 1;
            else
                return 0;
        }
    }

    public void ordena(List<Coordenada> vertices) {
        Comparator<Coordenada> comparador = new ordenaVertice();
        Collections.sort(vertices, comparador);
    }

    @Override

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder cadena = new StringBuilder();
        for (Coordenada vertice : vertices) {
            cadena.append(vertice.toString());
            cadena.append(" Magnitud:" + Double.valueOf(df.format(Magnitud(vertice))));
            cadena.append(", ");
        }
        return cadena.toString();
    }
}