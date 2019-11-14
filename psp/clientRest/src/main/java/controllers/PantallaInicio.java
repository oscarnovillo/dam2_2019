package controllers;

import dao.TestInterceptor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import utils.CifradoCesar;
import utils.Constantes;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaInicio implements Initializable {

    ExecutorService executorService;
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
                .addInterceptor(new TestInterceptor())
                .build();


        executorService = Executors.newFixedThreadPool(1);
    }

    @FXML
    private void menuLogin(ActionEvent actionEvent) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(Constantes.BASE_URL + Constantes.URL_LOGIN).newBuilder();
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
        Task<String> tarea = new Task<String>() {
            public StringProperty test;
            @Override
            protected String call() throws Exception {
                HttpUrl.Builder urlBuilder
                        = HttpUrl.parse(Constantes.BASE_URL + "/visitas").newBuilder();

                String url = urlBuilder.build().toString();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Call call = clientOK.newCall(request);
                Response response = call.execute();
                CifradoCesar cf = new CifradoCesar();
                cf.descifra(response.body().string(),1);

                return response.body().string();
                //return "OK";
            }
        };


       // fxText.textProperty().bind(tarea.valueProperty());
        tarea.setOnSucceeded(workerStateEvent -> {
                fxText.setText(tarea.getValue());
        });
        tarea.setOnFailed(workerStateEvent ->
                Logger.getLogger("PantallaInicio")
                        .log(Level.SEVERE, "error ",
                                workerStateEvent.getSource().getException()));
        new Thread(tarea).start();
        executorService.submit(tarea);


        Service<String> service = new Service<String>() {
            private StringProperty valueNuevo = new SimpleStringProperty();

            public String getValueNuevo() {
                return valueNuevo.get();
            }

            public StringProperty valueNuevoProperty() {
                return valueNuevo;
            }

            @Override
            protected Task<String> createTask() {
                return null;
            }
        };


    }


    @FXML
    private void menuCifrado(ActionEvent actionEvent) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("nombre", "caca")
                .build();

        Request request = new Request.Builder()
                .url(Constantes.BASE_URL + "/cifrado")
                .post(formBody)
                .build();

        Call call = clientOK.newCall(request);
        Response response = call.execute();
        fxText.setText(response.body().string());

    }

    public void menuContador(ActionEvent actionEvent) throws InterruptedException {
        int numero;
        fxText.setText("0");
        do {
            numero = Integer.parseInt(fxText.getText());
            Thread.sleep(1000);
            numero++;
            fxText.setText(numero + "");
        }
        while (numero < 10);


    }

    public void menuContadorOk(ActionEvent actionEvent) throws InterruptedException {
        Task<Void> task = new Task<Void>() {


            @Override
            protected Void call() throws Exception {
                int numero = 0;
                updateMessage(numero + "");
                updateProgress(10, 100);
                do {
                    //numero = Integer.parseInt(fxText.getText());
                    Thread.sleep(1000);
                    numero++;
                    updateMessage(numero + "");
                }
                while (numero < 10);
                return null;
            }
        };
        task.setOnSucceeded(workerStateEvent -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("TAREA ACABADA");
            a.showAndWait();

        });
        task.setOnFailed(workerStateEvent ->
                Logger.getLogger("PantallaInicio")
                        .log(Level.SEVERE, "error ",
                                workerStateEvent.getSource().getException()));

        fxText.textProperty().bind(task.messageProperty());


        new Thread(task).start();


    }
}
