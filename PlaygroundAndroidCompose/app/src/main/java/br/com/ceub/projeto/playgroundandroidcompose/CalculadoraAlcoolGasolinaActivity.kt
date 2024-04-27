package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme
import java.text.NumberFormat
import java.util.Locale


/*
TODO Atividade
 - Crie o campo Etanol para ser repassado como parâmetro.
 - Transforme Strings em resource

  - Desafio de aula
   - Como atualizar o valor do texto com o resultado do da porcentagem.
 */
class CalculadoraAlcoolGasolinaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    CalculadoraApp()
                }
            }
        }
    }
}


@Composable
fun CalculadoraApp() {

    var valorEntrada by remember {
        mutableStateOf("3,89")
    }

    //Segunda etapa
    val formatadorNumero = NumberFormat.getNumberInstance(Locale("pt", "BR"))
    val valorGasolinaNumerico = formatadorNumero.parse(valorEntrada)?.toDouble() ?: 0.0
    val textoResultado = calcularEtanolVersusGasolina(valorGasolina = valorGasolinaNumerico)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Etanol X Gasolina",
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.titleLarge
        )
        CampoNumerico(valor = valorEntrada, onValorAlterado = { valorEntrada = it })
        Text(
//            text = "Alcool em R$ 4,07 , vale a pena  usar Gasolina",
            text = textoResultado,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun CampoNumerico(
    valor: String,
    onValorAlterado: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(bottom = 32.dp)
        .fillMaxWidth()
) {

//    var valorEntrada by remember {
//        mutableStateOf("0")
//    }

    TextField(
        label = {
            Text(text = "R$ Gasolina")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        value = valor,
//        onValueChange = { valorEntrada = it },
        onValueChange = onValorAlterado,
        modifier = modifier
    )
}

private fun calcularEtanolVersusGasolina(
    valorGasolina: Double,
    valorEtanol: Double = 3.86
): String {

    val porcentagem = valorEtanol / valorGasolina
    val porcentagemFmt = NumberFormat.getPercentInstance().format(porcentagem)
    if (porcentagem > 0.7) {
        return "Vantagem em abastecer com Gasolina. Porcentagem em: ${porcentagemFmt}"
    }
    return "Vantagem em abastecer com Etanol. Porcentagem em: ${porcentagemFmt}"

}

@Preview
@Composable
fun CalculadoraAppPreview() {
    PlaygroundAndroidComposeTheme {
        Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
            CalculadoraApp()
        }
    }
}
