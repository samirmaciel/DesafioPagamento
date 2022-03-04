package com.example.desafiopagamento.feature.presentation.precardregister

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentPrecardregisterBinding

class PreCardRegisterFragment : Fragment(R.layout.fragment_precardregister) {

    private var _binding : FragmentPrecardregisterBinding? = null
    private val binding : FragmentPrecardregisterBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPrecardregisterBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()


        val userIDforTransaction = arguments?.getInt("userID", -1)

        binding.btnegister.setOnClickListener{
            val args = Bundle()

            args.apply {
                putInt("userID", userIDforTransaction!!)
            }
            findNavController().navigate(R.id.action_preCardRegisterFragment_to_cardRegisterFragment, args)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}