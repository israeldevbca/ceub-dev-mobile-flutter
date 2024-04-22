package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorBackground
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class FazerLimonadaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorBackground, modifier = Modifier.fillMaxSize()) {
                    LimonadaApp()
                }
            }
        }
    }
}

@Composable
fun LimonadaApp() {
    ComponenteImagemTextoLimonada()
}

@Composable
fun ComponenteImagemTextoLimonada() {

}


@Preview
@Composable
fun LimonadaAppPreview() {
    ComponenteImagemTextoLimonada()
}
