package com.example.latihanrv.detail.fetched

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanrv.network.ApiCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondFragViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response
    init {
        initData()
    }
    private fun initData() {
        ApiCall.retrofitService.showList().enqueue(object: Callback<String> {
                override fun onFailure (call: Call<String>, t: Throwable) {
            _response.value = t.message
        }
                override fun onResponse (call: Call<String>, response: Response<String>) {
            _response.value = response.body()
        }
    })
    _response.value = "just data placeholder"

}
}