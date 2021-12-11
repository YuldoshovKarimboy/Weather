package com.example.myapplication.core.network

import com.example.myapplication.core.model.AutoCompleteSearch
import com.example.myapplication.core.model.FiveDailyForecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("locations/v1/cities/autocomplete")
    fun autocompleteSearch(
        @Query("apikey") apiKey: String,
        @Query("q") query: String
    ): Call<AutoCompleteSearch>

    @GET("forecasts/v1/daily/5day/{locationKey}")
    fun fiveDayForecast(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey: String
    ): Call<FiveDailyForecast>
}