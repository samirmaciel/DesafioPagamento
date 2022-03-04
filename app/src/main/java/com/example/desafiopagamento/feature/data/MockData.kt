package com.example.desafiopagamento.feature.data

import android.app.Application
import com.example.desafiopagamento.R
import com.example.desafiopagamento.feature.domain.model.Card
import com.example.desafiopagamento.feature.domain.model.Transaction
import com.example.desafiopagamento.feature.domain.model.User

class MockData : Application(){

    var userCard : Card? = null
    var transactionList = mutableListOf<Transaction>()
    var transactionLastID = 0

    companion object {

        var instance : MockData? = null

        fun getIntance() : MockData{
            if(instance == null){
                instance = MockData()
            }

            return instance!!
        }
    }

    fun findUserById(userID : Int) : User? {
        for (user in getAllContacts()){
            if(user.id == userID){
                return user
            }
        }

        return null
    }

    fun registerCard(card : Card){
        userCard = card
    }

    fun getAllContacts() : MutableList<User>{
        return mutableListOf(
            User(
                id = 1,
                nickname = "@aliceromero",
                name = "Aline Romero",
                drawableID = R.drawable.user1
            ),
            User(
                id = 2,
                nickname = "@caiovibes",
                name = "Caio Borges",
                drawableID = R.drawable.user8
            ),
            User(
                id = 3,
                nickname = "@danlop",
                name = "Daniel Lopes",
                drawableID = R.drawable.user7
            ),
            User(
                id = 4,
                nickname = "@depaula",
                name = "Eliane de Paula",
                drawableID = R.drawable.user6
            ),
            User(
                id = 5,
                nickname = "@fab.dias",
                name = "Fabrício Dias",
                drawableID = R.drawable.user5
            ),
            User(
                id = 6,
                nickname = "@figueiredo.bruna",
                name = "Bruna Figueredo",
                drawableID = R.drawable.user4
            ),
            User(
                id = 7,
                nickname = "@gust",
                name = "Gustavo Almeida",
                drawableID = R.drawable.user3
            ),
            User(
                id = 8,
                nickname = "@helena",
                name = "Helena Pacheco",
                drawableID = R.drawable.user2
            ),
            User(
                id = 9,
                nickname = "@igor.m",
                name = "Igor Matos",
                drawableID = R.drawable.user9
            ),
            User(
                id = 10,
                nickname = "@zelda.williams",
                name = "Zelda Willians",
                drawableID = R.drawable.user10
            ),
        )
    }

    fun registerTransaction(transaction: Transaction){
        transactionList.add(transaction)
    }

    fun getTransactionById(transactionID : Int): Transaction? {
           for (transaction in transactionList){
               if(transaction.id == transactionID){
                   return transaction
               }
           }

        return null
    }
}