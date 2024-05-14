import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//PoligonoIrreg
public class PoligonoIrreg {
    private Coordenada[] vertices;
    private int numVertices;

    public PoligonoIrreg(int n) {
        vertices = new Coordenada[n];
        numVertices = 0;
    }

    public void anadeVertice(Coordenada vertice) {
        if (numVertices < vertices.length) {
            vertices[numVertices] = vertice;
            numVertices++;
        }
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Polígono irregular con los siguientes vértices: ");
        for (int i = 0; i < numVertices; i++) {
            cadena.append(vertices[i].toString());
            if (i != numVertices - 1) {
                cadena.append(", ");
            }
        }
        return cadena.toString();
    }
}
