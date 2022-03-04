package com.example.desafiopagamento.feature.domain.model

data class Card(
    val cardNumber : String,
    val holderName : String,
    val cardFlag : String = "MasterCard",
    val dueDate : String,
    val cardCvv : Int
)
