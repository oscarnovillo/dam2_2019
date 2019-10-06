package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import utils.Constantes;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class PantallaInicio implements Initializable {

  @FXML
  private MenuItem fxMenuLogin;
  @FXML
  private TextArea fxText;

  private OkHttpClient clientOK;

  public void test(ActionEvent actionEvent) {
    Alert a = new Alert(Alert.AlertType.INFORMATION);
    a.setContentText("file");
    a.showAndWait();
  }


  @FXML
  private void menuClose(ActionEvent actionEvent) {
    Alert a = new Alert(Alert.AlertType.INFORMATION);
    a.showAndWait();
  }


  private void pedirHttpClient11() {
    HttpClient client = HttpClient.newBuilder()
        // Redirect except https to http
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    try {

      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://www.marca.com"))
          .GET()
          .build();

      client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
          .thenAccept(response -> fxText.setText(response.body()));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    clientOK = new OkHttpClient.Builder()
        .cookieJar(new JavaNetCookieJar(cookieManager))
        .build();
  }

  @FXML
  private void menuLogin(ActionEvent actionEvent) {
    HttpUrl.Builder urlBuilder
        = HttpUrl.parse(Constantes.BASE_URL + "/login").newBuilder();
    urlBuilder.addQueryParameter("user", "root");
    urlBuilder.addQueryParameter("pass", "root");

    String url = urlBuilder.build().toString();
    Request request = new Request.Builder()
        .url(url)
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


  @FXML
  private void menuVisitas(ActionEvent actionEvent) throws IOException {

    HttpUrl.Builder urlBuilder
        = HttpUrl.parse(Constantes.BASE_URL + "/visitas").newBuilder();

    String url = urlBuilder.build().toString();
    Request request = new Request.Builder()
        .url(url)
        .build();

    Call call = clientOK.newCall(request);
    Response response = call.execute();
        fxText.setText(response.body().string());

  }
}
