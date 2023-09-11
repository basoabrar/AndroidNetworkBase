package com.example.latihanrv.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.latihanrv.R
import com.example.latihanrv.databinding.FragmentThirdBinding



class ThirdFragment : Fragment() {

    private lateinit var  carbinding : FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carbinding = DataBindingUtil.inflate(inflater, R.layout.fragment_third, container , false)

        return carbinding.root
    }

}