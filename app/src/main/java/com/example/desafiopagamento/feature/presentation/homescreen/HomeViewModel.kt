package com.example.desafiopagamento.feature.presentation.homescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.User

class HomeViewModel(val db : MockData) : ViewModel() {

    var contactsWorkList : MutableLiveData<MutableList<User>> = MutableLiveData()
    var userBaseList : MutableList<User> = mutableListOf()

    init {
        getAllContacts()
    }

    fun checkUserCard() : Boolean {
        return db.userCard != null
    }

    private fun getAllContacts(){
        contactsWorkList.value = db.getAllContacts()
        userBaseList = db.getAllContacts()
    }

    fun searchContact(text : String){
        contactsWorkList.value = userBaseList.filter { contact ->
            contact.nickname.contains(text, true) || contact.name.contains(text, true)
        }.toMutableList()
    }

    class HomeViewModelFactory(val db : MockData) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(db) as T
        }
    }
}