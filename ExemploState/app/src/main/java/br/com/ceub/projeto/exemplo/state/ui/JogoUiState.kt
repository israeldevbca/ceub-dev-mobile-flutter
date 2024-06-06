package br.com.ceub.projeto.playgroundandroidcompose.misturaletras.ui

data class JogoUiState(
    val palavraEmbaralhadaAtual: String = "",
    val isPalavraIncorreta: Boolean = false,
    val pontuacao: Int = 0,
    val contadorPalavras: Int = 1,
    val isFimJogo: Boolean = false
)
