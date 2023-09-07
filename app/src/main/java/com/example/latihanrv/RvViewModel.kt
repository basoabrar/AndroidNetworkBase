package com.example.latihanrv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RvViewModel : ViewModel() {

    private val _menu = MutableLiveData<ArrayList<Makanan>>()

    val menu : LiveData<ArrayList<Makanan>>
        get() = _menu

    init {
        _menu.value = arrayListOf(
            Makanan(R.drawable.avatar_dp , "Item 1" , 200), //0
            Makanan(R.drawable.avatar_dp , "Item 2" , 100), //1
            Makanan(R.drawable.avatar_dp , "Item 3" , 400), //2
            Makanan(R.drawable.avatar_dp , "Item 4" , 400)
        )
    }

}