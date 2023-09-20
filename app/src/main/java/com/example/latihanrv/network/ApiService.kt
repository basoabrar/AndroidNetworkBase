package com.example.latihanrv.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET



private val retrofit = Retrofit. Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl("http://10.0.2.2:5000/")
    .build()

//API interface
interface ApiService{
    @GET("songs")
    fun showList():
            Call<String>
}
object ApiCall {
    val retrofitService = retrofit.create(ApiService::class.java)
}