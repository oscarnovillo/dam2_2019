package retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.AreasRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ControllerAreasAPI implements Callback<AreasRequest> {
  static final String BASE_URL = "https://api.football-data.org/v2/";

  public void start() {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    AreasAPI gerritAPI = retrofit.create(AreasAPI.class);

    Call<AreasRequest> call = gerritAPI.loadAreas();
    call.enqueue(this);

  }

  @Override
  public void onResponse(Call<AreasRequest> call, Response<AreasRequest> response) {
    if(response.isSuccessful()) {
      AreasRequest changesList = response.body();
      changesList.getAreas().stream().forEach(change -> System.out.println(change.getName()));
    } else {
      try {
        System.out.println(response.errorBody().string());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void onFailure(Call<AreasRequest> call, Throwable throwable) {

  }
}
