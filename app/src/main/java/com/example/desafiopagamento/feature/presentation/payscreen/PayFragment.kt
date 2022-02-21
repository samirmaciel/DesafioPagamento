package com.example.desafiopagamento.feature.presentation.payscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentPayBinding
import com.example.desafiopagamento.feature.utils.MoneyTextWatcher

class PayFragment : Fragment(R.layout.fragment_pay){

    private var _bingind : FragmentPayBinding? = null
    private val binding : FragmentPayBinding get() = _bingind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bingind = FragmentPayBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()

        binding.edtMoneyInput.addTextChangedListener(MoneyTextWatcher(binding.edtMoneyInput))

        setClickListeners()

    }

    private fun setClickListeners(){
        binding.keyboardComponent.btnKeyboard1.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}1")
        }
        binding.keyboardComponent.btnKeyboard2.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}2")
        }
        binding.keyboardComponent.btnKeyboard3.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}3")
        }
        binding.keyboardComponent.btnKeyboard4.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}4")
        }
        binding.keyboardComponent.btnKeyboard5.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}5")
        }
        binding.keyboardComponent.btnKeyboard6.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}6")
        }
        binding.keyboardComponent.btnKeyboard7.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}7")
        }
        binding.keyboardComponent.btnKeyboard8.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}8")
        }
        binding.keyboardComponent.btnKeyboard9.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}9")
        }
        binding.keyboardComponent.btnKeyboard0.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}0")
        }

        binding.keyboardComponent.btnBackSpace.setOnClickListener {
            var textFromInput = binding.edtMoneyInput.text

            var cleanString = textFromInput.toString().replace("[,.]".toRegex(), "").replace("\\s+".toRegex(), "")

            var stringToInput = cleanString.drop(1)

            Log.d("SocketFuck", "setClickListeners: " + stringToInput)

            binding.edtMoneyInput.setText(stringToInput)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _bingind = null
    }
}