package com.example.myretrofit.data.api


import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("npm/country-flag-emoji-json@2.0.0/dist/index.json")
    fun getCountryList(): Call<List<CountryModel>>
}