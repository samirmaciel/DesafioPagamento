package com.example.desafiopagamento.feature.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import java.lang.NumberFormatException
import java.text.NumberFormat
import java.util.*

class MoneyTextWatcher(private val editText : EditText) : TextWatcher {

    private val locale : Locale = Locale("pt", "BR")

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }


    override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if(s.toString().isNotEmpty()){
            editText.removeTextChangedListener(this)

            val monetarySignal = Currency.getInstance(locale).symbol

            var cleanString = s.toString().replace("[${monetarySignal},.]".toRegex(), "").replace("\\s+".toRegex(), "")

            if(cleanString.length != 0){

                try {
                    var parsed : Double
                    var formatted : String

                    parsed = cleanString.toDouble()

                    formatted = NumberFormat.getCurrencyInstance(locale).format(parsed / 100)

                    var formattedWithOutSymbol = formatted.replace("R$", "")

                    if(formattedWithOutSymbol.length <= 9){
                        editText.setText(formattedWithOutSymbol)
                        editText.setSelection(formattedWithOutSymbol.length)
                    }

                }catch (e : NumberFormatException){
                    Log.d("MoneyTextWatcher", "onTextChanged: " + e.printStackTrace().toString())
                }
            }
            editText.addTextChangedListener(this)
        }
    }

    override fun afterTextChanged(p0: Editable?) {

    }

}