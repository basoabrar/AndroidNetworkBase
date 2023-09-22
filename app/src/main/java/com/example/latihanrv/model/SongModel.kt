package com.example.latihanrv.model

data class SongResponse(
    val status: String,
    val data: SongData
)

data class SongData(
    val songs: List<Song>
)

data class Song(
    val id: String,
    val title: String,
    val performer: String
)


