package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.ApiError;
import modelo.Book;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.hibernate.validator.cdi.HibernateValidator;
import retrofit.BooksApi;
import retrofit.UsuarioApi;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Set;


public class MainError {


  public static void main(String[] args) throws IOException {

    final String BASE_URL = "http://localhost:8080/payara/api/";
    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    OkHttpClient clientOK = new OkHttpClient.Builder()
        .cookieJar(new JavaNetCookieJar(cookieManager))
//        .addInterceptor(chain -> {
//          Request original = chain.request();
//
//          Request.Builder builder1 = original.newBuilder()
//              .header("X-Auth-Token", "2deee83e549c4a6e9709871d0fd58a0a")
//              .url(original.url().newBuilder().addQueryParameter("headToken","adfsdf").build());
//          Request request = builder1.build();
//          return chain.proceed(request);}
//        )
        .build();
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(clientOK)
        .build();


    BooksApi bookApi = retrofit.create(BooksApi.class);

    Book book = new Book("",2);
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator val = factory.getValidator();
    val.validate(book).stream().forEach(bookConstraintViolation -> System.out.println(bookConstraintViolation.getMessage()));


    bookApi.addBook(book).execute();
    bookApi.addBook(Book.builder().name("error").build()).execute();
    bookError(bookApi,gson);



  }

  public static void bookError(BooksApi bookApi,Gson gson) throws IOException
  {
    Response<Book> resp = bookApi.addBook(Book.builder().name("error").build()).execute();
    if (resp.isSuccessful())
    {
      System.out.println(resp.body());
    }
    else
    {
      //System.out.println(resp.errorBody().string());
      ApiError error = gson.fromJson(resp.errorBody().charStream(), ApiError.class);
      System.out.println(error);
    }
  }

}
