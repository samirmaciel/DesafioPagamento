package com.example.desafiopagamento.feature.domain.model

data class Transaction(
    var id : Int = 1,
    val card_number: String,
    val cvv: Int,
    val destination_user_id: Int,
    val transactionDateTime : String,
    val expiry_date: String,
    val value: String
)