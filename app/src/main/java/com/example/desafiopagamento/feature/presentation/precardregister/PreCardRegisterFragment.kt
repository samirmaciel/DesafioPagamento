package com.example.desafiopagamento.feature.presentation.precardregister

import androidx.fragment.app.Fragment
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentPrecardregisterBinding

class PreCardRegisterFragment : Fragment(R.layout.fragment_precardregister) {

    private var _binding : FragmentPrecardregisterBinding? = null
    private val binding : FragmentPrecardregisterBinding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}