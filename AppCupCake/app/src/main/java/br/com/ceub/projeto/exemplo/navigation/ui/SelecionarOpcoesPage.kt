package br.com.ceub.projeto.exemplo.navigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.exemplo.navigation.SubTotalComponent
import br.com.ceub.projeto.exemplo.navigation.data.CupcakeDataSource
import br.com.ceub.projeto.exemplo.navigation.ui.theme.AppCupCakeTheme

@Composable
fun SelecionarOpcoesPage(
    subTotal: String,
    opcoes : List<String>,
    onSelecionarOpcao: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {

    // rememberSaveable mantem o valor salvo entre recomposições por exemplo: ao girar a tela
    var saborSelecionado by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier,
        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            opcoes.forEach { opcao ->
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.selectable(
                        selected = saborSelecionado == opcao,
                        onClick = {
                            saborSelecionado = opcao
                            onSelecionarOpcao(opcao)
                        }),
                ) {
                    RadioButton(
                        selected = false,
                        onClick = { onSelecionarOpcao(opcao) }
                    )
                    Text(text = opcao)
                }
            }
        }
        Divider(
            thickness = 2.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        SubTotalComponent(subTotal)
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Cancelar")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                Text(text = "Próximo")
            }
        }

    }
}

@Preview
@Composable
fun SelecionarOpcoesPagePreview() {
    AppCupCakeTheme {
        Surface {
            SelecionarOpcoesPage(opcoes = CupcakeDataSource.sabores, subTotal = "R$ 30,00", modifier = Modifier.fillMaxSize())
        }
    }
}
