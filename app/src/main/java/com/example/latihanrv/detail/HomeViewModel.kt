package com.example.latihanrv.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanrv.model.Song
import com.example.latihanrv.network.ApiCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    fun refresh(){
        initData()
    }
    private val _menu = MutableLiveData<List<Song>>()

    val menu : LiveData<List<Song>>
        get() = _menu


    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)
    init {
        initData()

        _menu.value = listOf(
            Song(id = "1" , title = "yang", performer = "wali" )
        )
    }

    private fun initData() {
        crScope.launch{
            try {
                val items = ApiCall.retrofitService.showList()
                val songData = items.data

                if(songData.songs.isNotEmpty()) {
                    val firstSong = songData.songs
                    _menu.postValue(firstSong)
                }

            } catch (t: Throwable) {
                Log.i("'api error", t.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}