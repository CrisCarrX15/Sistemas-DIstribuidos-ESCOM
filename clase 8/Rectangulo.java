public class Rectangulo {
    private Coordenada superiorIzq, superiorDer;


    public Rectangulo(Coordenada superiorIzq, Coordenada superiorDer){
        this.superiorIzq = superiorIzq;
        this.superiorDer = superiorDer;
    }

    //Metodo getter de superiorIzq
    public Coordenada superiorIzq(){
        return superiorIzq;
    }

    //Metodo getter de superiorDer
    public Coordenada superiorDer(){
        return superiorDer;
    }

    @Override

    public String toString() {
        return "Rectangulo con esquinas superior izquierda en " + superiorIzq + " y superior derecha en " + superiorDer;
    }
}
