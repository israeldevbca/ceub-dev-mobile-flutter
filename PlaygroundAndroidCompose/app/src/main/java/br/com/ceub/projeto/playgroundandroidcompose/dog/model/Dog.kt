package br.com.ceub.projeto.playgroundandroidcompose.dog.model

import androidx.annotation.DrawableRes
import br.com.ceub.projeto.playgroundandroidcompose.R

data class Dog(
    @DrawableRes val img: Int,
    val nome: String,
    val idade: Int,
    val hoobie: String
)

val listaDogs = listOf(
    Dog(R.drawable.koda, "Koda", 2, "Comer Terra"),
    Dog(R.drawable.lola, "Lola", 16, "Brincar"),
    Dog(R.drawable.frankie, "Frankie", 2, "Se esconder"),
    Dog(R.drawable.nox, "Nox", 8, "Conhecer novos animais"),
    Dog(R.drawable.faye, "Fye", 8, "Cagar no jardim"),
    Dog(R.drawable.bella, "Bella", 14, "Surfar"),
    Dog(R.drawable.moana, "Moana", 2, "Chatear seus donos"),
    Dog(R.drawable.tzeitel, "Tzeitel", 7, "Tomar banho de sol"),
    Dog(R.drawable.leroy, "Leroy", 4, "Dormir o dia inteiro")
)
