package sazby_dph;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    public String zavolejAPI(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // this is the default
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://euvatrates.com/rates.json"))
                .GET()   // this is the default
                .header("accept", "application/json")
                .build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // 2) Nacist JSON soubor
        String JSONtext = response.body().toString();
        return JSONtext;
    }

}
