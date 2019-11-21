package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Usuario;
import retrofit.LoginApi;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MainUsuario {

    public static void main(String[] args) throws IOException {
        final String BASE_URL = "http://localhost:8080/login/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LoginApi login = retrofit.create(LoginApi.class);

        Response<String> resp = login.login(new Usuario("jj", "mm")).execute();
        //resp.isSuccessful()
        if (resp.isSuccessful())
            System.out.println(resp.body());
        else
        {
            System.out.println("ERROR " + resp.code());
        }


    //    login.login().execute().body().stream().forEach(System.out::println);
    }
}
