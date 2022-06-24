package com.salsabila.idn.getapi.api

import com.salsabila.idn.getapi.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news?apikey=pub_8564072fec9e96e63f0ee7072281d8e25e6d&q=pegasus&language=en")
    fun getNews() : Call<ResponseNews>

}