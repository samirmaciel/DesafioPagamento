package com.example.desafiopagamento.feature.presentation.payscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.Card
import com.example.desafiopagamento.feature.domain.model.Transaction
import com.example.desafiopagamento.feature.domain.model.User

class PayViewModel(val db : MockData) : ViewModel() {

    var userForTransaction : MutableLiveData<User> = MutableLiveData()

    fun registerTransaction(transaction: Transaction) : Int{
        db.transactionLastID++
        transaction.id = db.transactionLastID
        db.registerTransaction(transaction)

        return transaction.id
    }

    fun getCard() : Card {
        return db.userCard!!
    }

    fun getUserByID(userId : Int){
        val user = db.findUserById(userId)

        userForTransaction.value = user
    }

    class PayViewModelFactory(val db : MockData) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PayViewModel(db) as T
        }

    }
}