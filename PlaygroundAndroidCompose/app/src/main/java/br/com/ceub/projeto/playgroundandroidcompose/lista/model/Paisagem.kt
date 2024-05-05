package br.com.ceub.projeto.playgroundandroidcompose.lista.model

import androidx.annotation.DrawableRes

data class Paisagem(
    val descricao: String,
    @DrawableRes val idImage: Int
)
