package com.example.win8

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Util {
    val BASE_URL = "http://49.12.202.175/"
    val ONE_SIGNAL_KEY = "714b9f14-381d-4fc4-a93c-28d480557381"
    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}