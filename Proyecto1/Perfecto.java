public class Perfecto {
    public static void main(String[] args) {
        int suma;
        for (int i = 1; i <= 10000; i++) {
            suma = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    suma = suma + j;
                }

            }
            if (i == suma) {
                System.out.println(i);
            }
        }

    }

}
