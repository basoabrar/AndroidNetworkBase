package com.example.latihanrv.network

import com.example.latihanrv.model.Song
import com.example.latihanrv.model.SongData

import com.example.latihanrv.model.SongResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


private val retrofit = Retrofit. Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("http://10.0.2.2:5000/")
    .build()

//API interface
interface ApiService{
    @GET("songs")
    suspend fun showList(): SongResponse

    @POST("songs")
    suspend fun  submbitSong(@Body songRequest: SongRequest) : SongResponse
}
object ApiCall {
    val retrofitService = retrofit.create(ApiService::class.java)
}