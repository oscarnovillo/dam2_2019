package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fj.data.Either;

import fj.parser.Result;
import modelo.ApiError;
import modelo.Usuario;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit.LoginApi;
import retrofit.UsuarioApi;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;

public class MainUsuarioJAX {

  public static void main(String[] args) throws IOException {
    final String BASE_URL = "http://localhost:8080/payara/api/";
    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    OkHttpClient clientOK = new OkHttpClient.Builder()
        .cookieJar(new JavaNetCookieJar(cookieManager))
        .addInterceptor(chain -> {
          Request original = chain.request();

          Request.Builder builder1 = original.newBuilder()
              .header("X-Auth-Token", "2deee83e549c4a6e9709871d0fd58a0a")
              .url(original.url().newBuilder().addQueryParameter("headToken","adfsdf").build());
          Request request = builder1.build();
          return chain.proceed(request);}
        )
        .build();
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(clientOK)
        .build();

    UsuarioApi login = retrofit.create(UsuarioApi.class);

    Response<List<Usuario>> resp = login.loadUsuarios().execute();
    //resp.isSuccessful()
    if (resp.isSuccessful())
      System.out.println(resp.body());
    else
    {
      System.out.println("ERROR " + resp.code()+resp.message());
    }

    Usuario u = new Usuario("lo","lo");
    Response<Usuario> add = login.addUser(u).execute();
    if (add.isSuccessful())
    {
      System.out.println(add.body());
    }
    else
    {
      System.out.println("ERROR " + add.code()+add.message());
    }


    Response<List<Usuario>> resp1 = login.loadUsuarios().execute();
    //resp.isSuccessful()
    if (resp1.isSuccessful())
      System.out.println(resp1.body());
    else
    {
      System.out.println("ERROR " + resp1.code()+resp1.message());
    }
    //    login.login().execute().body().stream().forEach(System.out::println);

    //loadUsuarios(login).isLeft()
  }



  public static Either<ApiError, List<Usuario>> loadUsuarios(UsuarioApi login) throws IOException{

    Response<List<Usuario>> resp = login.loadUsuarios().execute();
    if (resp.isSuccessful()) {
      return Either.right(resp.body());
    } else {
      return Either.left(ApiError.builder().message("ERROR " + resp.code() + resp.message()).build());
    }
  }

//  public static Result<List<Usuario>> loadUsuarios2(UsuarioApi login) throws IOException{
//
//    Response<List<Usuario>> resp = login.loadUsuarios().execute();
//    if (resp.isSuccessful()) {
//      return (resp.body());
//    } else {
//      return Either.left(ApiError.builder().message("ERROR " + resp.code() + resp.message()).build());
//    }
//  }

}
