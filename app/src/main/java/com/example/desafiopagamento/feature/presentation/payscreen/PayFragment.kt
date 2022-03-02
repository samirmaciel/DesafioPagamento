package com.example.desafiopagamento.feature.presentation.payscreen

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
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

        binding.edtMoneyInput.doOnTextChanged{ text, _, _, _ ->
            binding.btnPay.isEnabled = !text.isNullOrEmpty()
        }

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
            backSpaceKeyboardFeature()
        }
    }

    private fun backSpaceKeyboardFeature(){
        if(binding.edtMoneyInput.text.length > 0){

            var stringWithOnlyNumber = binding.edtMoneyInput.text.toString().replace("[,.]".toRegex(), "").replace("\\s+".toRegex(), "")

            if(stringWithOnlyNumber[0].toString().equals("0", true)){
                stringWithOnlyNumber = stringWithOnlyNumber.drop(1)

                if(stringWithOnlyNumber[0].toString().equals("0", true)) {
                    stringWithOnlyNumber = stringWithOnlyNumber.drop(1)
                }
            }

            stringWithOnlyNumber = stringWithOnlyNumber.drop(1)

            if (stringWithOnlyNumber.length == 0){
                stringWithOnlyNumber = ""
            }

            binding.edtMoneyInput.setText(stringWithOnlyNumber)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _bingind = null
    }
}