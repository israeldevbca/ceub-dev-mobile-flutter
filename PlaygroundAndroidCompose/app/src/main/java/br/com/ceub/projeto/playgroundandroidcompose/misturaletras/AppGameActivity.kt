package br.com.ceub.projeto.playgroundandroidcompose.misturaletras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.ceub.projeto.playgroundandroidcompose.misturaletras.ui.Jogo
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class AppGameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Jogo(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

}
