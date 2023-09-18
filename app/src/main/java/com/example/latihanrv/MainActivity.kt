package com.example.latihanrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView

import com.example.latihanrv.databinding.ActivityMainBinding

//step step membuat recyclerview
// 1. membuat rv_item
// 2. membuat widget RecyclerView
// 3. membuat adapter

// private lateinit var viewAdapter : RecyclerView.Adapter<*>
// private lateinit var viewManager : RecyclerView.LayoutManager



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}