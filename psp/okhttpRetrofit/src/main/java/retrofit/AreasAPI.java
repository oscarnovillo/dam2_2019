package retrofit;

import modelo.AreasRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AreasAPI {

  @GET("areas/")
  Call<AreasRequest> loadAreas();

}
