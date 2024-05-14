
// Java program to illustrate
// ThreadPool
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task class to be executed (Step 1)
class Task implements Runnable {
    private String name;

    public Task(String s) {
        name = s;
        String fileName = "BIBLIA_COMPLETA.txt";
        Map<Character, Integer> charCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = br.read()) != -1) {
                char character = (char) c;
                if (charCountMap.containsKey(character)) {
                    int count = charCountMap.get(character);
                    charCountMap.put(character, count + 1);
                } else {
                    charCountMap.put(character, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Número de caracteres distintos encontrados: " + charCountMap.size());
        System.out.println("Mapa de caracteres distintos y sus ocurrencias:");
        System.out.println(charCountMap);
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                if (i == 0) {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - " + name + " = " + ft.format(d));
                    // prints the initialization time for every task
                } else {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - " +
                            name + " = " + ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class prueba {
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args) {
        // creates five tasks
        Runnable r1 = new Task("task 1");
        /*
         * Runnable r2 = new Task("task 2");
         * Runnable r3 = new Task("task 3");
         * Runnable r4 = new Task("task 4");
         * Runnable r5 = new Task("task 5");
         */

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
