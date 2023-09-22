package com.example.latihanrv.detail.fetched

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.latihanrv.model.Song

import com.example.latihanrv.model.SongResponse

import com.example.latihanrv.network.ApiCall
import com.example.latihanrv.network.SongRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class SecondFragViewModel : ViewModel() {

    private val _response = MutableLiveData<SongResponse>()
    val response : LiveData<SongResponse>
        get() = _response


    private val _songR = MutableLiveData<Song>()
    val songR : LiveData<Song>
        get() = _songR


    private val _sumbitSongResponse = MutableLiveData<SongResponse>()
    val submitSongResponse : LiveData<SongResponse>
        get() = _sumbitSongResponse


    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData()
    }

    fun login(songRequest: SongRequest) = viewModelScope.launch {
        try {
            val response = ApiCall.retrofitService.submbitSong(songRequest)
            _sumbitSongResponse.value = response
            initData()
        } catch (e: Exception) {
            // Handle the exception (e.g., network error)
        }
    }


    private fun initData() {
        crScope.launch{
            try {
                val items = ApiCall.retrofitService.showList()
                val songData = items.data

                if(songData.songs.isNotEmpty()) {
                    val firstSong = songData.songs.last()
                    _songR.postValue(firstSong)
                }

            } catch (t: Throwable) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}


//        ApiCall.retrofitService.showList().enqueue(object: Callback<SongData> {
//                override fun onFailure (call: Call<SongData>, t: Throwable) {
//            _response.value = t.message
//        }
//                override fun onResponse (call: Call<SongData>, response: Response<SongData>) {
//            _response.value = "Berhasil"
//        }
//    })