package com.example.desafiopagamento.feature.presentation.homescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockContacts
import com.example.desafiopagamento.feature.domain.model.Contact

class HomeViewModel(val db : MockContacts) : ViewModel() {

    var contactsWorkList : MutableLiveData<MutableList<Contact>> = MutableLiveData()
    var contactBaseList : MutableList<Contact> = mutableListOf()

    init {
        getAllContacts()
    }

    private fun getAllContacts(){
        contactsWorkList.value = db.getAllContacts()
        contactBaseList = db.getAllContacts()
    }

    class HomeViewModelFactory(val db : MockContacts) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(db) as T
        }

    }
}