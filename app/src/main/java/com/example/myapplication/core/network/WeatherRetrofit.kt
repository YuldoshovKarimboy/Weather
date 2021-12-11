package com.example.myapplication.core.network

import com.example.myapplication.core.base_url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRetrofit {

    fun api(): WeatherApi = retrofit().create(WeatherApi::class.java)

    private fun retrofit(): Retrofit =
        Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())
            .client(client()).build()

    private fun client(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor()).build()

    private fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
}