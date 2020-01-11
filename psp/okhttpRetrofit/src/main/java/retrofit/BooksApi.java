package retrofit;

import modelo.Book;
import modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface BooksApi {

  @GET("books/")
  Call<List<Book>> loadBooks();

  @POST("books/")
  Call<Book> addBook(@Body Book book);
}
