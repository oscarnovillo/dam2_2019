package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ResourceBundle;

public class PantallaInicioTest implements Initializable {

  public MenuItem fxMenuClose;
  public TextArea fxText;

  public void test(ActionEvent actionEvent) {
  }

  public void menuClose(ActionEvent actionEvent) {
    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
    a.showAndWait();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    fxMenuClose.setText("jjjj");

    HttpClient client = HttpClient.newBuilder()
        // Redirect except https to http
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    try {

      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://www.marca.com"))
          .GET()
          .build();

//      client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//          .thenAccept(response -> fxText.setText(response.body()));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    OkHttpClient clientOK = new OkHttpClient();

    Request request = new Request.Builder()
        .url("http://www.as.com")
        .build();

    Call call = clientOK.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        fxText.setText("ERROR");
      }

      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        fxText.setText(response.body().string());
      }
    });

  }
}
