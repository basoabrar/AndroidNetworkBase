package com.example.latihanrv.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.latihanrv.R

import com.example.latihanrv.databinding.FragmentHomeBinding
import com.example.latihanrv.detail.fetched.HomeAdapter.SongListAdapter


class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        var viewManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL , false)





        val viewAdapter = SongListAdapter()
        binding.rv.adapter = viewAdapter

        binding.rv.layoutManager = viewManager

        viewModel.menu.observe(this , Observer {
            list -> viewAdapter.submitList(list)
        })




        binding.icon.setOnClickListener {
          it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()

    }

}