package retrofit;

import modelo.AreasRequest;
import modelo.CompetitionsRequest;
import retrofit2.Call;
import retrofit2.http.*;

import modelo.Area;


public interface AreasAPI {

  @GET("areas/")
  Call<AreasRequest> loadAreas();

  @GET("areas/{id}")
  Call<Area> loadOneArea(@Path("id") int id);

  @GET("competitions/")
  Call<CompetitionsRequest> loadCompetitions( @Query("areas") int areas);

}
