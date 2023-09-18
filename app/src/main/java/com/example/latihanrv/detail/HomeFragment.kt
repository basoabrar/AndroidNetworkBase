package com.example.latihanrv.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanrv.ListAdapter
import com.example.latihanrv.R
import com.example.latihanrv.RvViewModel

import com.example.latihanrv.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private lateinit var viewModel: RvViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false)
        viewModel = ViewModelProvider(this).get(RvViewModel::class.java)
        var viewManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL , false)
        var viewAdapter = ListAdapter(
            viewModel
        )

        binding.rv.layoutManager = viewManager
        binding.rv.adapter = viewAdapter




        binding.icon.setOnClickListener {
          it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }
        return binding.root
    }

}