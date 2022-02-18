package com.example.desafiopagamento.feature.presentation.cardregister

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentCardregisterBinding
import com.example.desafiopagamento.feature.utils.DateTextWatcher

class CardRegisterFragment : Fragment(R.layout.fragment_cardregister) {

    private var _binding : FragmentCardregisterBinding? = null
    private val binding : FragmentCardregisterBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCardregisterBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()
        binding.tieCVV.addTextChangedListener(DateTextWatcher(binding.tieCVV))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}