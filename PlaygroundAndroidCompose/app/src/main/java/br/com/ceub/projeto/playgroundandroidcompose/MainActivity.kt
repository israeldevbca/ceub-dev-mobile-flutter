package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("TELA", "ACESSANDO onCreate")

        setContent {
            PlaygroundAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Cabecalho(nome = "Fernando", sobreNome = "Dias")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("TELA", "ACESSANDO onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("TELA", "ACESSANDO onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("TELA", "ACESSANDO onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("TELA", "ACESSANDO onPause")
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Magenta) {
        Text(
            text = "Olá Mundo  $name!",
            fontSize = 60.sp,
            lineHeight = 50.sp,
            modifier = modifier.padding(32.dp)
        )
    }
}

@Composable
fun ItemBloco(valor: String) {
    Surface(
        modifier = Modifier
            .width(80.dp)
            .height(40.dp), color = Color.DarkGray
    ) {
        Box {
            Text(
                text = valor,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Composable
fun Cabecalho(
    nome: String,
    sobreNome: String,
    modifier: Modifier = Modifier
) {
    Surface {
        Box(modifier) {
            Image(
                painter = painterResource(id = R.drawable.background_app),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                alpha = 0.4F
            )
            Column {
                Box(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "Logo Usuário",
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Column(modifier = modifier.padding(32.dp)) {
                            Text(text = nome, fontSize = 40.sp, fontWeight = FontWeight.Bold)
                            Text(
                                text = sobreNome,
                                fontSize = 12.sp,
                                modifier = modifier.align(Alignment.End)
                            )
                        }
                    }
                }
                /*
                    Crie um linha com 3 elementos,
                     - Adicione  na row horizontalArrangement
                     - Faça testes com Arrangement.*
                     - Adicione  na row modifier = Modifier.fillMaxSize()
                 */
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ItemBloco(valor = stringResource(id = R.string.numero_1))
                    ItemBloco(valor = stringResource(id = R.string.numero_2))
                    ItemBloco(valor = stringResource(id = R.string.numero_3))
                }
            }
        }

    }
}


@Preview(name = "Cabeçalho")
@Composable
fun CabecalhoPreview() {
    PlaygroundAndroidComposeTheme {
        Cabecalho(nome = "Fernando", sobreNome = "Dias")
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PlaygroundAndroidComposeTheme {
//        Greeting(name = "Fernando Dias")
//    }
//}
