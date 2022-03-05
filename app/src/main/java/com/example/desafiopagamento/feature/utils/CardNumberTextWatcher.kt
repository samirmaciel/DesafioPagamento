package com.example.desafiopagamento.feature.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

class CardNumberTextWatcher(private val editText: TextInputEditText) : TextWatcher {

    var lastChar : String = ""

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        var sizeEditText = editText.text.toString().length

        if(sizeEditText > 1){
            lastChar = editText.text.toString().substring(sizeEditText - 1)
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if(!s.toString().isEmpty()) {

            editText.removeTextChangedListener(this)

            var sizeEditText = editText.text.toString().length
            if(sizeEditText == 4) {
                if (!lastChar.equals("-")) {
                    editText.append("-")
                } else {
                    editText.text?.delete(sizeEditText - 1, sizeEditText - 1)
                }
            }else if(sizeEditText == 9){
                if (!lastChar.equals("-")) {
                    editText.append("-")
                } else {
                    editText.text?.delete(sizeEditText - 1, sizeEditText - 1)
                }
//                if(lastChar.contains("[23456789]".toRegex())){
//
//                }
            }else if (sizeEditText == 14) {
                if (!lastChar.equals("-")) {
                    editText.append("-")
                } else {
                    editText.text?.delete(sizeEditText - 1, sizeEditText - 1)
                }
            }

            editText.addTextChangedListener(this)

        }
    }
}