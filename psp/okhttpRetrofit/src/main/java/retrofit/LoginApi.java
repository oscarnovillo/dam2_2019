package retrofit;

import modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

  @POST("login")
  Call<String> login(@Body Usuario usuario);
}
