
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
 */
/*Carrillo Soto Cristian Eduardo
 * 4CM13
 * Proyecto_4
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class WebServer {
    private static final String SEARCH_ENDPOINT = "/search";
    private final int port;
    private HttpServer server;

    public static void main(String[] args) {
        int serverPort = 8080;
        if (args.length == 1) {
            serverPort = Integer.parseInt(args[0]);
        }

        WebServer webServer = new WebServer(serverPort);
        webServer.startServer();

        System.out.println("Servidor escuchando en el puerto " + serverPort);
    }

    public WebServer(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpContext searchContext = server.createContext(SEARCH_ENDPOINT);
        searchContext.setHandler(this::handleSearchRequest);

        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }

    private int searchOccurrencesInText(String searchWord) {
        int occurrences = 0;
        String cadena = "BIBLIA_COMPLETA.txt";

        System.out.print(searchWord);

        // Búsqueda de palabra
        try {
            Scanner scanner = new Scanner(new File(cadena));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int index = line.indexOf(searchWord);
                while (index >= 0) {
                    index = line.indexOf(searchWord, index + searchWord.length());
                    occurrences++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(" " + occurrences);

        return occurrences;
    }

    private void handleSearchRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }

        Headers headers = exchange.getRequestHeaders();
        boolean isDebugMode = false;

        if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
            isDebugMode = true;
        }

        byte[] requestBytes = exchange.getRequestBody().readAllBytes();
        String searchWord = new String(requestBytes).trim();

        int occurrences = searchOccurrencesInText(searchWord);

        String responseMessage = String.format("La palabra '%s' aparece %d veces en el texto.\n", searchWord,
                occurrences);
        sendResponse(responseMessage.getBytes(), exchange);
    }

    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}
