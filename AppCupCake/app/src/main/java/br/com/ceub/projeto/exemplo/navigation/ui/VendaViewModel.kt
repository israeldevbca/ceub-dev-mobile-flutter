package br.com.ceub.projeto.exemplo.navigation.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


private const val PRECO_CUPCAKE = 5.00

class VendaViewModel : ViewModel() {



    private val _uiState = MutableStateFlow(VendaUiState())
    val uiState : StateFlow<VendaUiState> = _uiState.asStateFlow()

    fun setQuantidade(quantidade: Int) {
        _uiState.update { status ->
            status.copy(
                quantidade = quantidade,
                valor = calcularValor(quantidade = quantidade)
            )
        }
    }

    fun setSabor(sabor: String) {
        _uiState.update { status ->
            status.copy(
                sabor = sabor
            )
        }
    }
    fun reiniciarVenda() {
        _uiState.value = VendaUiState()
    }

    private fun calcularValor(
        quantidade: Int = _uiState.value.quantidade,
    ) : String {
        var valorCalculado = quantidade * PRECO_CUPCAKE
        val precoFormatado = NumberFormat.getCurrencyInstance().format(valorCalculado)
        return precoFormatado
    }

}
