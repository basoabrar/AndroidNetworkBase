package com.example.latihanrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrv.databinding.ActivityMainBinding

//step step membuat recyclerview
// 1. membuat rv_item
// 2. membuat widget RecyclerView
// 3. membuat adapter

// private lateinit var viewAdapter : RecyclerView.Adapter<*>
// private lateinit var viewManager : RecyclerView.LayoutManager



class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RvViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding  : ActivityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main)

//        val recyclerView  = findViewById<RecyclerView>(R.id.rv)
//        val btn_add = findViewById<Button>(R.id.button_add)
//        var listArray = listOf("Pecel", "Rawon", "Nasi Goreng")

        viewModel = ViewModelProvider(this).get(RvViewModel::class.java)
        var viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false)
        var viewAdapter = ListAdapter(
            viewModel
        )

        binding.rv.layoutManager = viewManager
        binding.rv.adapter = viewAdapter


        binding.buttonAdd.setOnClickListener {
            viewAdapter.addItem(Makanan(R.drawable.cat , "Item 5" , 4000))
        }
    }


}