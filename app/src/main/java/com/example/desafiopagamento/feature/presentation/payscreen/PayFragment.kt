package com.example.desafiopagamento.feature.presentation.payscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentPayBinding

class PayFragment : Fragment(R.layout.fragment_pay){

    private var _bingind : FragmentPayBinding? = null
    private val binding : FragmentPayBinding get() = _bingind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bingind = FragmentPayBinding.bind(view)
    }



    override fun onDestroy() {
        super.onDestroy()
        _bingind = null
    }
}