package br.com.ceub.projeto.exemplo.navigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.exemplo.navigation.SubTotalComponent
import br.com.ceub.projeto.exemplo.navigation.ui.theme.AppCupCakeTheme

@Composable
fun ResumoVendaPage(
    vendaUiState: VendaUiState,
    modifier: Modifier
){
    Column(modifier = modifier) {
        Column{
            ItemPedido(descricao = "Quantidade", valor = "${vendaUiState.quantidade} Quantidade")
            ItemPedido(descricao = "Sabor", valor = "${vendaUiState.sabor}")
            ItemPedido(descricao = "Data", valor = "${vendaUiState.data}")
        }
        SubTotalComponent(subTotal = vendaUiState.valor)
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            Column(){
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                    Text(text = "Finalizar")
                }
                OutlinedButton(onClick = { /*TODO*/ },  modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}

@Composable
fun ItemPedido(descricao: String, valor: String) {
    Column(modifier = Modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(text = descricao.toUpperCase())
        Text(text = valor, fontWeight = FontWeight.Bold)
        Divider()
    }
}

@Preview
@Composable
fun ResumoVendaPagePreview() {
    AppCupCakeTheme {
        Surface {
            ResumoVendaPage(vendaUiState = VendaUiState(), modifier = Modifier.fillMaxSize())
        }
    }
}
