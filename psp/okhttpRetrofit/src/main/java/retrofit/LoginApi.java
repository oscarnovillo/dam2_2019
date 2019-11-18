package retrofit;

import modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface LoginApi {

  @POST("login")
  Call<String> login(@Body Usuario usuario);

  @PUT("login")
  Call<Usuario> actualizar(@Body Usuario usuario);

  @DELETE("login")
  Call<String> borrar(@Query("id") int idUsuario);

  @GET("login")
  Call<List<Usuario>> login ();

  @GET("login")
  Call<Usuario> login (@Query("id") int idUsuario);


}
