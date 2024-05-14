public class Coordenada {
    private double x, y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double Magnitud(double x, double y) {
        double magnitudx = Math.sqrt(Math.pow(x, 2) + Math.pow(x, 2));
        double magnitudy = Math.sqrt(Math.pow(y, 2) + Math.pow(y, 2));
        return Double.compare(magnitudx, magnitudy);
        // return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

    // metodos getter de x
    public double abcisa() {
        return x;
    }

    // metodos getter de y
    public double ordenada() {
        return y;
    }

    @Override

    public String toString() {
        return "(" + x + "," + y + ")";
    }

}