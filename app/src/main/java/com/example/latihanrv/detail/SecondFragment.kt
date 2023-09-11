package com.example.latihanrv.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.latihanrv.R
import com.example.latihanrv.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second,container,false)

        binding.edtPassword.text = args.password
        binding.edtUsername.text = args.username

        binding.button3.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            it.findNavController().navigate(action)
        }

        return binding.root
    }

}