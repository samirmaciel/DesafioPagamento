package com.example.desafiopagamento.feature.presentation.cardregister

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentCardregisterBinding
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.Card
import com.example.desafiopagamento.feature.utils.DateTextWatcher

class CardRegisterFragment : Fragment(R.layout.fragment_cardregister) {

    private var _binding : FragmentCardregisterBinding? = null
    private val binding : FragmentCardregisterBinding get() = _binding!!
    private val viewModel : CardRegisterViewModel by viewModels {
        CardRegisterViewModel.CardRegisterViewModelFactory(
            MockData.getIntance()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCardregisterBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()

        val userIDTransaction = arguments?.getInt("userID", -1)

        binding.btnSaveCard.setOnClickListener{
            if(checkInputs()){
                val card = Card(cardNumber = binding.tieCardNumber.text.toString(),
                    holderName = binding.tieCardHolderName.text.toString(),
                    cardCvv = binding.tieCVV.text.toString().toInt(),
                    dueDate = binding.tieCardHDueDate.toString()
                )
                viewModel.registerCard(card)
            }

            Toast.makeText(requireContext(), "Cartão registrado com sucesso!", Toast.LENGTH_SHORT).show()

            val args = Bundle().apply {
                putInt("userID", userIDTransaction!!)
            }

            findNavController().navigate(R.id.action_cardRegisterFragment_to_payFragment2, args)
        }

        binding.tieCardHDueDate.addTextChangedListener(DateTextWatcher(binding.tieCardHDueDate))

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun checkInputs() : Boolean {
        if(binding.tieCardNumber.text.isNullOrEmpty()){
            return false
        }
        if(binding.tieCVV.text.isNullOrEmpty()){
            return false
        }
        if(binding.tieCardHolderName.text.isNullOrEmpty()){
            return false
        }
        if(binding.tieCardHDueDate.text.isNullOrEmpty()){
            return false
        }
        if(binding.tieCardNumber.text.isNullOrEmpty()){
            return false
        }

        return true

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}