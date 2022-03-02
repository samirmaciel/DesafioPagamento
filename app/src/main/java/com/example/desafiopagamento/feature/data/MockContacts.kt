package com.example.desafiopagamento.feature.data

import com.example.desafiopagamento.R
import com.example.desafiopagamento.feature.domain.model.Contact

object MockContacts {

    fun getAllContact() : MutableList<Contact>{
        return mutableListOf(
            Contact(
                nickname = "@aliceromero",
                name = "Aline Romero",
                drawableID = R.drawable.user1
            ),
            Contact(
                nickname = "@caiovibes",
                name = "Caio Borges",
                drawableID = R.drawable.user8
            ),
            Contact(
                nickname = "@danlop",
                name = "Daniel Lopes",
                drawableID = R.drawable.user7
            ),
            Contact(
                nickname = "@depaula",
                name = "Eliane de Paula",
                drawableID = R.drawable.user6
            ),
            Contact(
                nickname = "@fab.dias",
                name = "Fabrício Dias",
                drawableID = R.drawable.user5
            ),
            Contact(
                nickname = "@figueiredo.bruna",
                name = "Bruna Figueredo",
                drawableID = R.drawable.user4
            ),
            Contact(
                nickname = "@gust",
                name = "Gustavo Almeida",
                drawableID = R.drawable.user3
            ),
            Contact(
                nickname = "@helena",
                name = "Helena Pacheco",
                drawableID = R.drawable.user2
            ),
            Contact(
                nickname = "@igor.m",
                name = "Igor Matos",
                drawableID = R.drawable.user9
            ),
            Contact(
                nickname = "@zelda.williams",
                name = "Zelda Willians",
                drawableID = R.drawable.user10
            ),
        )
    }
}