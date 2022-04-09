package com.example.myretrofit.data.retrofit

import com.example.myretrofit.application.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        val URL = BASE_URL

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}