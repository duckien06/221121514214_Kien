package com.example.a221121514214_LeDucKien.network;

import com.example.a221121514214_LeDucKien.model.Item;
import com.example.a221121514214_LeDucKien.model.Weather;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface APIManager {
    String SERVER_URL = "https://imdb236.p.rapidapi.com/";
//    https://imdb236.p.rapidapi.com/imdb/tt7631058
//    Header:
//          x-rapidapi-host: imdb236.p.rapidapi.com
//          x-rapidapi-key: 4f6ce08ff2msh3ddde25479a6adep1cf117jsn622984730b04

    @Headers({
            "x-rapidapi-host: imdb236.p.rapidapi.com",
            "x-rapidapi-key: 4f6ce08ff2msh3ddde25479a6adep1cf117jsn622984730b04"
    })
//   1 hình và 3 text
    @GET("imdb/{id}")
    Call<Item> getItemData(@Path("id") String movieId);

    @Headers({
            "x-rapidapi-host: imdb236.p.rapidapi.com",
            "x-rapidapi-key: 4f6ce08ff2msh3ddde25479a6adep1cf117jsn622984730b04"
    })
    @GET("imdb/top250-movies")
    Call<List<Item>> getListData();

    String BASE_URL = "https://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}