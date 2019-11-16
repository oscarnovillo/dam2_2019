package retrofit;

import modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface LoginApi {

  @POST("login")
  Call<String> login(@Body Usuario usuario);

  @GET("login")
  Call<List<Usuario>> login ();
}
