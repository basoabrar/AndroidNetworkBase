package com.example.latihanrv.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SongRequest{
    @SerializedName("title")
    @Expose
    var title: String? = null


    @SerializedName("year")
    @Expose
    var year: Int? = null

    @SerializedName("performer")
    @Expose
    var performer: String? = null

    @SerializedName("genre")
    @Expose
    var genre: String? = null

    @SerializedName("duration")
    @Expose
    var duration: Int? = null
}