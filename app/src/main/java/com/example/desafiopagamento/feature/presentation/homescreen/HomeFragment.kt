package com.example.desafiopagamento.feature.presentation.homescreen

import androidx.fragment.app.Fragment
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding get() = _binding!!

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}