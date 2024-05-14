/*
 *  MIT License
 *
 *  Copyright (c) 2019 Michael Pogrebinsky - Distributed Systems & Cloud Computing with Java
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * 
 */
/*Carrillo Soto Cristian Eduardo
 * 4CM13
 * Proyecto_4
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public List<String> sendTasksToWorkers(List<String> workerAddresses, List<String> tasks) {
        int numWorkers = workerAddresses.size();
        int numTasks = tasks.size();
        int currentIndex = 0;
        int[] taskIndices = new int[numWorkers]; // Índices de tareas asignadas a cada trabajador
        CompletableFuture<String>[] futures = new CompletableFuture[numWorkers];
        List<String> results = new ArrayList<>();

        // Inicializar los índices de tareas asignadas a cada trabajador
        for (int i = 0; i < numWorkers; i++) {
            taskIndices[i] = i;
        }

        // Distribuir las tareas entre los servidores
        while (currentIndex < numTasks) {
            for (int i = 0; i < numWorkers; i++) {
                int taskIndex = taskIndices[i];
                if (taskIndex >= numTasks) {
                    continue; // El trabajador ya ha terminado todas las tareas asignadas
                }

                String workerAddress = workerAddresses.get(i);
                String task = tasks.get(taskIndex);

                byte[] requestPayload = task.getBytes();
                futures[i] = webClient.sendTask(workerAddress, requestPayload);

                // Imprimir la tarea y la IP a la que se envió
                System.out.println("Tarea enviada: " + task + ", IP del servidor: " + workerAddress);

                taskIndices[i] += numWorkers; // Incrementar el índice de la tarea asignada al trabajador

                currentIndex++; // Incrementar el índice general de tareas
            }
        }

        // Recibir las respuestas de los servidores e imprimir la palabra y el número de
        // ocurrencias
        for (int i = 0; i < numWorkers; i++) {
            if (futures[i] != null) {
                String result = futures[i].join();
                results.add(result);

                // Verificar si la respuesta contiene el separador ":"
                if (result.contains(":")) {
                    // Extraer la palabra y el número de ocurrencias del resultado
                    String[] parts = result.split(":");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    // Imprimir la palabra y el número de ocurrencias provenientes del servidor
                    System.out.println("Palabra: " + word + ", Ocurrencias: " + count);
                } else {
                    System.out.println("Respuesta inválida del servidor: " + result);
                }
            }
        }

        return results;
    }
}
