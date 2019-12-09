package retrofit;

import modelo.AreasRequest;
import modelo.Usuario;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface UsuarioApi {

  @GET("usuario/")
  Call<List<Usuario>> loadUsuarios();

  @POST("usuario/")
  Call<Usuario> addUser(@Body Usuario user);


}
