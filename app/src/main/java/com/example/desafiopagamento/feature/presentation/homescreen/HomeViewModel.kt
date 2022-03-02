package com.example.desafiopagamento.feature.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockContacts

class HomeViewModel(val db : MockContacts) : ViewModel() {




    class HomeViewModelFactory(val db : MockContacts) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(db) as T
        }

    }
}