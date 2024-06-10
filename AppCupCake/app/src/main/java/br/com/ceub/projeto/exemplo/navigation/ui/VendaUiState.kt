package br.com.ceub.projeto.exemplo.navigation.ui

import java.text.SimpleDateFormat
import java.util.Calendar

data class VendaUiState(
    val quantidade: Int = 0,
    val sabor: String = "",
    val data : String =  SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time),
    val valor: String = "",
    val opcoesSelecionadas: List<String> = emptyList()
)
