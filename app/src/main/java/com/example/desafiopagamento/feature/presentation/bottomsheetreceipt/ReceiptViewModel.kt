package com.example.desafiopagamento.feature.presentation.bottomsheetreceipt

import android.view.SurfaceControl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.Transaction
import com.example.desafiopagamento.feature.domain.model.User

class ReceiptViewModel(val db : MockData) : ViewModel() {

    var curruentTransaction : MutableLiveData<Transaction> = MutableLiveData()

    fun getTransactionByID(transactionID : Int) {
        val transaction = db.getTransactionById(transactionID)
        curruentTransaction.value = transaction
    }

    fun getUserByID(userID : Int) : User? {
        return db.findUserById(userID)
    }


    class ReceiptViewModelFactory(val db : MockData) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ReceiptViewModel(db) as T
        }

    }
}