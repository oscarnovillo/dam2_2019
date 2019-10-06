package main;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainTestHttpClient {

  public static void main(String[] args) throws URISyntaxException {
    HttpClient client = HttpClient.newBuilder()
        // Redirect except https to http
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("http://horstmann.com"))
        .GET()
        .build();


//    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//        .thenAccept(response -> );
  }
}
