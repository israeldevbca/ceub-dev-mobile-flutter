package br.com.ceub.projeto.playgroundandroidcompose.misturaletras.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.ceub.projeto.playgroundandroidcompose.misturaletras.data.PalavrasDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class JogoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(JogoUiState())
    val uiState: StateFlow<JogoUiState> = _uiState.asStateFlow()

    private var palavrasUsadas: MutableSet<String> = mutableSetOf()
    private lateinit var palavraAtual: String

    var tentativaPalavra by mutableStateOf("")
        private set

    init {
        reiniciarJogo()
    }

    private fun embaralharPalavra(palavra: String): String {
        val palavraArray = palavra.toCharArray()
        palavraArray.shuffle()
        while (String(palavraArray) == palavra) {
            palavraArray.shuffle()
        }
        return String(palavraArray)
    }

    private fun getPalavraEmbaralhada(): String {
        palavraAtual = PalavrasDataSource().todasAsPalavras.random()
        if (palavrasUsadas.contains(palavraAtual)) {
            return getPalavraEmbaralhada()
        } else {
            palavrasUsadas.add(palavraAtual)
            return embaralharPalavra(palavraAtual)
        }
    }

    fun getTotalPalavras(): Int {
        return PalavrasDataSource().todasAsPalavras.size
    }

    fun reiniciarJogo() {
        palavrasUsadas.clear()
        _uiState.value = JogoUiState(palavraEmbaralhadaAtual = getPalavraEmbaralhada())
    }

    fun atualizarTentativaAdivinharPalavra(tentantiva: String) {
        tentativaPalavra = tentantiva
    }

    private fun atualizarJogoSucessoState(pontuacaoAtualizada: Int) {
        if (palavrasUsadas.size == getTotalPalavras()) {

            _uiState.update { status -> //atualiza a ui
                status.copy(
                    pontuacao = pontuacaoAtualizada,
                    isPalavraIncorreta = false,
                    isFimJogo = true
                )
            }

        } else {
            _uiState.update { status -> //atualiza a ui
                status.copy(
                    pontuacao = pontuacaoAtualizada,
                    isPalavraIncorreta = false,
                    palavraEmbaralhadaAtual = getPalavraEmbaralhada(),
                    contadorPalavras = status.contadorPalavras.inc()
                )
            }
        }
    }

    fun verificarTentativaPalavra() {
        if (tentativaPalavra.equals(palavraAtual, ignoreCase = true)) {
            val pontuacaoAtualizada = _uiState.value.pontuacao.plus(1) //Atualiza
            atualizarJogoSucessoState(pontuacaoAtualizada)
        } else {
            _uiState.update { status ->
                status.copy(isPalavraIncorreta = true)
            }
        }
        atualizarTentativaAdivinharPalavra("")
    }

    fun pularPalavra() {
        atualizarJogoSucessoState(_uiState.value.pontuacao)
        atualizarTentativaAdivinharPalavra("")
    }


}
