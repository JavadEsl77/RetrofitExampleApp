package com.example.myretrofit.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myretrofit.data.api.CountryModel
import com.example.myretrofit.data.retrofit.RetroInstance
import com.example.myretrofit.data.api.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {
    var LiveDataList: MutableLiveData<List<CountryModel>>

    init {
        LiveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<CountryModel>> {
        return LiveDataList
    }

    fun makeAPICall() {
        val retrofitInstance = RetroInstance.getRetroInstance()
        val retroService = retrofitInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getCountryList()
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                LiveDataList.postValue(response.body())

                for (i in 0..10) {
                    val a = response.body()?.get(i)?.name
                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                LiveDataList.postValue(null)
            }

        })

    }
}