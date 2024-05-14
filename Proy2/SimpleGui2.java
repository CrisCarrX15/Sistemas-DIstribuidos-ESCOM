import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SimpleGui2 extends JFrame {
    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.setVisible(true);
    }

    public SimpleGui2() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        add(p);
    }

    public class DibujarPoligonos extends JPanel {
        private ArrayList<PoligonoReg> poligonos;
        private int numPoligonos;
        private int ancho;
        private int alto;

        public DibujarPoligonos(int numPoligonos, int ancho, int alto) {
            this.poligonos = new ArrayList<PoligonoReg>();
            this.numPoligonos = numPoligonos;
            this.ancho = ancho;
            this.alto = alto;

            Random rand = new Random();
            for (int i = 0; i < numPoligonos; i++) {
                int numVertices = rand.nextInt(8) + 3;//Minimo de vetices
                double escala = rand.nextDouble() + 0.5;
                PoligonoReg poligono = new PoligonoReg(numVertices);
                poligono.escala(escala);
            }
        }
    }
}
