package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.AreasRequest;
import modelo.CompetitionsRequest;
import retrofit.AreasAPI;
import retrofit.ControllerAreasAPI;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import modelo.Area;
import java.io.IOException;

public class Main {


  public static void main(String[] args) throws IOException {

//      ControllerAreasAPI controller = new ControllerAreasAPI();
//      controller.start();
    final String BASE_URL = "https://api.football-data.org/v2/";
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    AreasAPI gerritAPI = retrofit.create(AreasAPI.class);

    Call<AreasRequest> call = gerritAPI.loadAreas();
    AreasRequest changesList = call.execute().body();
    changesList.getAreas().stream().forEach(change -> System.out.println(change.getName()));

    Call<Area> call1 = gerritAPI.loadOneArea(2224);

    System.out.println(call1.execute().body().toString());

    Call<CompetitionsRequest> call2 = gerritAPI.loadCompetitions("2deee83e549c4a6e9709871d0fd58a0a",2224);

    call2.execute().body().getCompetitions().stream().forEach(System.out::println);

  }
}
