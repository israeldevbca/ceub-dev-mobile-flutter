package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting("Android")
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
            modifier = modifier.padding(32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundAndroidComposeTheme {
        Greeting(name = "Fernando Dias")
    }
}