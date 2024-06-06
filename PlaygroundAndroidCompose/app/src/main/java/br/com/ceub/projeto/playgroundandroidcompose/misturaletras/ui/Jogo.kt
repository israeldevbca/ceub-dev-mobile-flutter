package br.com.ceub.projeto.playgroundandroidcompose.misturaletras.ui

import android.app.Activity
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

/*
    TODO
    1 - Trazer o conteúdo do appGame para dentro da função Jogo
    2 - Criar o parametro   jogoViewModel: JogoViewModel = JogoViewModel()
    3 - criar a val jogoUiState by jogoViewModel.uiState.collectAsState()
    4 - adicionar no JogoLayout a  palavraAtual: String
    5 - criar  onUsuarioFinalizadouAdivinhar e onUsuarioFinalizadouAdivinhar
    6 - criar var tentativaPalavra by mutableStateOf("") no JogoViewModel

 */



@Composable
fun Jogo(
    modifier: Modifier,
    jogoViewModel: JogoViewModel = viewModel() //Importante Importe viewModel default
) {

    val jogoUiState by jogoViewModel.uiState.collectAsState()

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
            onUsuarioFinalizadouAdivinhar = { jogoViewModel.verificarTentativaPalavra() },
            onUsuarioTentouAdivinhar = { tentativa ->
                jogoViewModel.atualizarTentativaAdivinharPalavra(tentativa)
            },
            tentativaPalavra = jogoViewModel.tentativaPalavra,
            totalPalavras = jogoViewModel.getTotalPalavras(),// Envio de dados a viewmodel
            palavraAtual = jogoUiState.palavraEmbaralhadaAtual, //Evento observavel
            isPalavraErrada = jogoUiState.isPalavraIncorreta,
            contadorPalavras = jogoUiState.contadorPalavras,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Button(
                modifier = modifier.padding(8.dp),
                onClick = { jogoViewModel.verificarTentativaPalavra() }) {
                Text(text = "Confirmar", style = MaterialTheme.typography.titleMedium)
            }
            OutlinedButton(
                modifier = modifier.padding(8.dp),
                onClick = { jogoViewModel.pularPalavra() }) {
                Text(text = "Pular", style = MaterialTheme.typography.titleMedium)
            }
        }
        Pontuacao(modifier = Modifier.padding(20.dp), pontuacao = jogoUiState.pontuacao)
    }

    if(jogoUiState.isFimJogo){
        PontuacaoFinalDialog(
            pontuacao = jogoUiState.pontuacao,
            onJogarNovamente = { jogoViewModel.reiniciarJogo() }
        )
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
fun JogoLayout(
    onUsuarioTentouAdivinhar: (String) -> Unit,
    onUsuarioFinalizadouAdivinhar: () -> Unit,
    palavraAtual: String,
    tentativaPalavra: String,
    isPalavraErrada: Boolean,
    contadorPalavras: Int,
    totalPalavras: Int,
    modifier: Modifier = Modifier
) {
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
                text = "$contadorPalavras/$totalPalavras", modifier = Modifier
                    .clip(RoundedCornerShape(12.dp)) //Brincar com  ordem aqui para explicar
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
                    .align(Alignment.End),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary

            )
            Text(text = palavraAtual, style = MaterialTheme.typography.displayMedium)
            Text(
                text = "Escreva a palavra que esta embaralhada.",
                style = MaterialTheme.typography.titleMedium,
            )
            OutlinedTextField(
                value = tentativaPalavra,
                onValueChange = onUsuarioTentouAdivinhar,
                singleLine = true,
                isError = isPalavraErrada,
                shape = MaterialTheme.shapes.large,
                label = {
                    if (isPalavraErrada) {
                        Text(text = "Palavre errada!")
                    } else {
                        Text(text = "Adivinhe a palavra")
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { onUsuarioFinalizadouAdivinhar() }),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                )
            )
        }
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
            Jogo(modifier = Modifier.fillMaxWidth())
        }
    }
}
