public class Prac1_Ej4 {
    public static void main(String[] args) {
        int aux = 0;
        int suma = 0;
        int aux2 = 1;
        int aux3 = 1;
        for (int i = 0; i <= 20; i++) {
            suma = aux + aux2 + aux3;
            aux = aux2;
            aux2 = aux3;
            aux3 = suma;

            System.out.println(suma);

        }
    }

}
