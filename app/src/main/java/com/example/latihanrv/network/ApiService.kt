package com.example.latihanrv.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET



private val retrofit = Retrofit. Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl("https://api.github.com/")
    .build()
//API interface
interface ApiService{
    @GET("repos/laravel/laravel/contributors")
    fun showList():
            Call<String>
}
object ApiCall {
    val retrofitService = retrofit.create(ApiService::class.java)
}