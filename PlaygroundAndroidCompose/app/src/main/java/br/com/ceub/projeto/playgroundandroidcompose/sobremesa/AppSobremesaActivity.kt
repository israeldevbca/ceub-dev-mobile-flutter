package br.com.ceub.projeto.playgroundandroidcompose.sobremesa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import br.com.ceub.projeto.playgroundandroidcompose.sobremesa.model.Sobremesa
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class AppSobremesaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() //Este layout agora se estenderá até as bordas físicas da tela
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding() // Aplica preenchimento para evitar sobreposição com a barra de status
                ) {


                }
            }
        }
    }
}

@Composable
fun SobremesaApp(listaSobremesa: List<Sobremesa>) {
    Scaffold(
        topBar = {
            val intentContext = LocalContext.current
            val layoutDirecao = LocalLayoutDirection.current


        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding))
    }
}
