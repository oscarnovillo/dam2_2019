package dao;

import config.ConfigurationSingleton_Client;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import utils.Constantes;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Log4j2
public class DaoProducto_cliente {


    public Either<String, List<String>> getTodosProductos() {
        AtomicReference<Either<String, List<String>>> resultado = new AtomicReference<>();
        OkHttpClient clientOK = ConfigurationSingleton_OkHttpClient.getInstance();

        //Por POST
        String url = ConfigurationSingleton_Client.getInstance().getPath_base() + Constantes.PRODUCTOS;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Try.of(() -> clientOK.newCall(request).execute())
                .onSuccess(response -> {
                    if (response.isSuccessful()) {
                        Try.of(() -> response.body().string())
                                .onSuccess(s ->
                                        resultado.set(Either.right(Arrays.asList(s.split(",")))))
                                .onFailure(throwable -> resultado.set(Either.left("error de comunicacion")));
                    } else
                        resultado.set(Either.left("Error en la comunicacion"));
                })
                .onFailure(ConnectException.class, throwable -> {
                    log.error(throwable.getMessage(), throwable);
                    resultado.set(Either.left("El servidor va lento y no se\nha podido CERRAR.\nDisculpe las molestias"));

                });

        return resultado.get();
    }

    public List addCesta(List productosAdd) {
        List cesta = null;
        try {
            OkHttpClient clientOK = ConfigurationSingleton_OkHttpClient.getInstance();
            //Por POST
            String url = ConfigurationSingleton_Client.getInstance().getPath_base() + Constantes.CESTA;
            FormBody.Builder b = new FormBody.Builder();
            for (int i = 0; i < productosAdd.size(); i++) {
                b.add(Constantes.PARAMETRO_PRODUCTOS, productosAdd.get(i).toString());
            }
            b.add(Constantes.PARAMETRO_OPCION_CESTA, Constantes.OPCION_ADD_CESTA);
            RequestBody formBody = b.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response resp = clientOK.newCall(request).execute();
            String productos = resp.body().string();
            //Desgloso string en array
            cesta = Arrays.asList(productos.split(","));
        } catch (ConnectException e) {
            log.info(e.getMessage(), e);
        } catch (IOException e) {
            log.info(e.getMessage(), e);
        }
        return cesta;
    }


    public String buyCesta(List productosBuy) {
        String mensaje = null;
        try {
            OkHttpClient clientOK = ConfigurationSingleton_OkHttpClient.getInstance();
            //Por POST
            String url = ConfigurationSingleton_Client.getInstance().getPath_base() + Constantes.CESTA;

            RequestBody formBody = new FormBody.Builder()
                    .add(Constantes.PARAMETRO_OPCION_CESTA, Constantes.OPCION_BUY_CESTA)
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response resp = clientOK.newCall(request).execute();
            mensaje = resp.body().string();
        } catch (ConnectException e) {
            log.info(e.getMessage(), e);
            mensaje = "El servidor va lento y no se\nha podido COMPRAR.\nDisculpe las molestias";
        } catch (IOException e) {
            log.info(e.getMessage(), e);
            mensaje = "Ha habido problemas al realizar la compra";
        }
        return mensaje;
    }

    public String clearCesta(List productosClear) {
        String mensaje = null;
        try {
            OkHttpClient clientOK = ConfigurationSingleton_OkHttpClient.getInstance();
            //Por POST
            String url = ConfigurationSingleton_Client.getInstance().getPath_base() + Constantes.CESTA;

            RequestBody formBody = new FormBody.Builder()
                    .add(Constantes.PARAMETRO_OPCION_CESTA, Constantes.OPCION_CLEAR_CESTA)
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response resp = clientOK.newCall(request).execute();
            mensaje = resp.body().string();
        } catch (ConnectException e) {
            log.info(e.getMessage(), e);
            mensaje = "El servidor va lento y no se\nha podido LIMPIAR.\nDisculpe las molestias";
        } catch (IOException e) {
            log.info(e.getMessage(), e);
            mensaje = "Ha habido problemas al limpiar la cesta";
        }
        return mensaje;
    }
}

