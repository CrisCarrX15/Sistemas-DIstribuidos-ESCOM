public class PruebaRectangulo {
    public static void main(String[] args) {
        Coordenada c1 = new Coordenada(2,3);
        Coordenada c2 = new Coordenada(5,1);

        Rectangulo rect1 = new Rectangulo(c1,c2);

        double ancho, alto;
        System.out.println("Callculado el área de un rectangulo dadas sus coordenadas en un plano carteciano:");
        System.out.println(rect1);
        ancho = rect1.superiorDer().abcisa() - rect1.superiorIzq().abcisa();
        alto = rect1.superiorIzq().ordenada() - rect1.superiorDer().ordenada();

        System.out.println("El área del rectangulo es: " + ancho*alto);
    }
}

