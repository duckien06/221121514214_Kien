package com.example.a221121514214_LeDucKien.network;

import com.example.a221121514214_LeDucKien.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPI {
    String BASE_URL = "https://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}
