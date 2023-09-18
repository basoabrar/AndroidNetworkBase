package com.example.latihanrv.detail.fetched

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.latihanrv.R
import com.example.latihanrv.RvViewModel
import com.example.latihanrv.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondFragViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SecondFragViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second,container,false)

        viewModel.response.observe(viewLifecycleOwner, Observer { response ->
            binding.textView2.text = response
        })

        binding.button3.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            it.findNavController().navigate(action)
        }

        return binding.root
    }

}