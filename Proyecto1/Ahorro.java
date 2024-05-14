public class Ahorro {

    public static void main(String[] args) {

        int tiempo = 20;
        double Ahorro = 0;
        double rendimiento = 0;
        for (int i = 0; i < tiempo; i++)

            Ahorro = Ahorro + 10000;

        rendimiento = (double) (Ahorro * 0.05);
        Ahorro = Ahorro + rendimiento;

        System.out.println("Ahorros totales después de 20 años: " + Ahorro);
    }

}
