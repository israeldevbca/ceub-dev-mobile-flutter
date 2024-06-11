import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class CalculadoraEtanolGasolina : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    AppCalculadora()
                }
            }
        }
    }
}

@Composable
fun AppCalculadora() {
    var valorEntrada by remember { mutableStateOf("") }

    val valorGasolina = valorEntrada.toDoubleOrNull() ?: 0.0

    val resultado = CalcularEtanolVersusGasolina(valorGasolina)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // TITULO
        Text(
            text = "Etanol X Gasolina",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        )

        // Campo numérico
        CampoNumerico(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            valorEntrada = valorEntrada,
            onValueChange = { valorEntrada = it })

        // Resultado
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            Text(
                text = resultado,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun CampoNumerico(
    modifier: Modifier = Modifier,
    valorEntrada: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        label = { Text(text = "R$ Gasolina") },
        value = valorEntrada,
        onValueChange = onValueChange
    )
}

// Função de cálculo
private fun CalcularEtanolVersusGasolina(valorGasolina: Double): String {
    // Se maior que 70%, vai de gasolina
    val porcentagem = valorGasolina / 3.89

    return if (porcentagem > 0.7) {
        "Vantagem em abastecer com Gasolina. Porcentagem em: $porcentagem"
    } else {
        "Vantagem em abastecer com Etanol. Porcentagem em: $porcentagem"
    }
}

@Preview
@Composable
fun AppCalculadoraPreview() {
    PlaygroundAndroidComposeTheme {
        Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
            AppCalculadora()
        }
    }
}
