package com.example.weather.APIService;

import com.example.weather.model.Weatherforecast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
//http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=28fc9310b6afe62f6c02871a74fda4c0
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    APIService apiservice = new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);

    @GET("data/2.5/weather")
    Call<Weatherforecast> getInforWeather(@Query("q") CharSequence q,
                                            @Query("APPID") String APPID);
}
