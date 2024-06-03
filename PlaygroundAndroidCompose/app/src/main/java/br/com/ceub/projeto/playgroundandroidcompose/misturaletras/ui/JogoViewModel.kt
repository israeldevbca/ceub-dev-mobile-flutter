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

    private val _uiState = MutableStateFlow(JogoUiState()) //Somente a viewmodel ver
    val uiState: StateFlow<JogoUiState> = _uiState.asStateFlow() // Aqui a Jogo pode usar

    private var palavraUsadas: MutableSet<String> = mutableSetOf()
    private lateinit var palavraAtual: String

    var tentativaPalavra by mutableStateOf("")
        private set

    init {
        reiniciarJogo()
    }

    fun reiniciarJogo() {
        palavraUsadas.clear()
        _uiState.value = JogoUiState(palavraEmbaralhada = getPalavraEmbaralhada())
    }

    fun embaralharPalavra(palavra: String): String {
        val palavraArray = palavra.toCharArray()
        palavraArray.shuffle()
        while (String(palavraArray) == palavra) {
            palavraArray.shuffle()
        }
        return String(palavraArray)
    }

    fun getPalavraEmbaralhada(): String {
        palavraAtual = PalavrasDataSource().todasAsPalavras.random()
        if (palavraUsadas.contains(palavraAtual)) {
            return getPalavraEmbaralhada()
        }
        palavraUsadas.add(palavraAtual)
        return embaralharPalavra(palavraAtual)
    }

    fun getTotalPalavras(): Int {
        return palavraUsadas.size
    }

    fun atualizaTentativaPalavra(valor: String) {
        tentativaPalavra = valor
    }

    fun verificarTentativaPalavra() {
        if (tentativaPalavra.equals(palavraAtual, ignoreCase = true)) {
            val pontuacaoAtualizada = _uiState.value.pontuacao.plus(1)
            atualizarStateSucessoJogo(pontuacaoAtualizada)
        } else {
            _uiState.update { status ->
                status.copy(isPalavraIncorreta = true)
            }
        }
        atualizaTentativaPalavra("")
    }

    fun atualizarStateSucessoJogo(pontuacaoAtualiza: Int) {
        _uiState.update { status ->
            status.copy(
                pontuacao = pontuacaoAtualiza,
                isPalavraIncorreta = false,
            )
        }
    }


}
