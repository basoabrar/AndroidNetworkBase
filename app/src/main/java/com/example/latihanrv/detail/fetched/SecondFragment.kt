package com.example.latihanrv.detail.fetched

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.latihanrv.R
import com.example.latihanrv.databinding.FragmentSecondBinding
import com.example.latihanrv.model.Song

import com.example.latihanrv.network.SongRequest


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondFragViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SecondFragViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second,container,false)

        viewModel.songR.observe(viewLifecycleOwner, Observer { response ->
            if(response.id.isNotEmpty()){
                updateUI(response)
            }
        })

        binding.btnCreate.setOnClickListener{

            var request = SongRequest()
            request.title = binding.edtAddMusic.text.toString()
            request.performer = binding.edtAddBand.text.toString()
            request.year = 2002
            request.duration = 120
            request.genre = "Hip Hop"

            if(
                binding.edtAddMusic.text.toString().isNotEmpty() &&
                binding.edtAddBand.text.toString().isNotEmpty()
                )
            {
                viewModel.login(request)
                binding.edtAddMusic.clearFocus()
                binding.btnCreate.clearFocus()
                Toast.makeText(requireContext(), "Data Berhasil Masuk", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Data Tidak Lengkap", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogout.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            it.findNavController().navigate(action)
        }

        return binding.root
    }

    private fun updateUI(data : Song){
        with(binding){
            tvFavBand.text = data.performer
            tvFavLagu.text = data.title
        }
    }

}