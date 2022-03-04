package com.example.desafiopagamento.feature.presentation.cardregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.Card

class CardRegisterViewModel(val db : MockData) : ViewModel() {

    fun registerCard(card : Card){
        db.userCard = card
    }


    class CardRegisterViewModelFactory(val db : MockData) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CardRegisterViewModel(db) as T
        }

    }
}