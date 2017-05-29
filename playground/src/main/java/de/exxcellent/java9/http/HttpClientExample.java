package de.exxcellent.java9.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import static java.lang.System.out;

public class HttpClientExample {

    /**
     * A API de HTTP com funções assíncronas e síncronas. No modo assíncrono,
     * o trabalho é feito nas threads suprimidas pelo ExecutorService do cliente.
     */
    public static void main(String[] args) throws Exception {
        HttpClient.getDefault()
                .request(URI.create("https://www.exxcellent.de"))
                .GET()
                .responseAsync() // CompletableFuture :D
                .thenAccept(httpResponse ->
                                    out.println(httpResponse.body(HttpResponse.asString()))
                );

        Thread.sleep(999); // Dê à thread worker algum tempo para trabalhar.
    }
}
