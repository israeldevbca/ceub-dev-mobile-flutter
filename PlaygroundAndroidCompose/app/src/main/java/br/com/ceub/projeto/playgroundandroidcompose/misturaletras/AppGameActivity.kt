package br.com.ceub.projeto.playgroundandroidcompose.misturaletras

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class AppGameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppGame(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

}

@Composable
fun Pontuacao(pontuacao: Int = 0, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Text(
            text = "Pontuação: $pontuacao",
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier.padding(8.dp)
        )
    }
}


@Composable
fun JogoLayout(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "0/1", modifier = Modifier
                    .clip(RoundedCornerShape(12.dp)) //Brincar com  ordem aqui para explicar
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
                    .align(Alignment.End),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary

            )
            Text(text = "PAVRASDSD", style = MaterialTheme.typography.displayMedium)
            Text(
                text = "Escreva a palavra que esta embaralhada.",
                style = MaterialTheme.typography.titleMedium,
            )
            OutlinedTextField(
                value = "",
                onValueChange = { valor -> },
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "Adivinhe a palavra") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {}),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                )
            )
        }
    }
}


@Composable
fun AppGame(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Embaralhar Palavra Game",
            style = MaterialTheme.typography.titleLarge
        )
        JogoLayout(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Button(modifier = modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                Text(text = "Confirmar", style = MaterialTheme.typography.titleMedium)
            }
            OutlinedButton(
                modifier = modifier.padding(8.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Pular", style = MaterialTheme.typography.titleMedium)
            }
        }
        Pontuacao(modifier = Modifier.padding(20.dp))
    }

}

@Composable
fun PontuacaoFinalDialog(
    pontuacao: Int,
    onJogarNovamente: () -> Unit,
    modifier: Modifier = Modifier
) {

    val activity = (LocalContext.current as Activity)

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            //Quando clica fora do Dialog
        },
        title = {
            Text(text = "Parabéns!")
        },
        text = {
            Text(text = "Sua Pontuação: $pontuacao")
        },
        dismissButton = {
            TextButton(onClick = {
                activity.finish()
            }) {
                Text(text = "Fechar")
            }
        },
        confirmButton = {
            TextButton(onClick = onJogarNovamente) {
                Text(text = "Jogar Novamente!")
            }
        })
}


@Preview
@Composable
fun AppGamePreview() {
    PlaygroundAndroidComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            AppGame(modifier = Modifier.fillMaxWidth())
        }
    }
}
