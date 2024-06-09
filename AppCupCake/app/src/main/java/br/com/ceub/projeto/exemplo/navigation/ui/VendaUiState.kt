package br.com.ceub.projeto.exemplo.navigation.ui

data class VendaUiState(
    val quantidade: Int = 5,
    val sabor: String = "Chocolate",
    val data : String = "12/12/2023",
    val valor: String = "R$ 30,00",
    val opcoesSelecionadas: List<String> = emptyList()
)
