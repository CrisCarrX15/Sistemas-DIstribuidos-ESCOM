
/*Carrillo Soto Cristian Eduardo
 * 4CM13
 * Proyecto_4
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Debe proporcionar las direcciones IP de los tres servidores y las palabras a buscar.");
            return;
        }

        String workerAddress1 = args[0];
        String workerAddress2 = args[1];
        String workerAddress3 = args[2];

        List<String> workerAddresses = Arrays.asList(workerAddress1, workerAddress2, workerAddress3);

        List<String> words = Arrays.asList(Arrays.copyOfRange(args, 3, args.length));

        Aggregator aggregator = new Aggregator();

        List<String> results = aggregator.sendTasksToWorkers(workerAddresses, words);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
