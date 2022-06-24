package com.salsabila.idn.getapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    const val baseUrl = "https://newsdata.io/api/1/"

    fun getRetrofit() : Retrofit {
        //yang di bawah ini di ambil dari retrofit configurasi di dokumentasi retrofit
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}