package com.example.latihanrv.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.latihanrv.R

import com.example.latihanrv.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.buttonSubmit.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtUsername.text.toString()

            val action =
                HomeFragmentDirections.actionHomeFragmentToSecondFragment(username, password)
            it.findNavController().navigate(action)
        }
        return binding.root
    }

}