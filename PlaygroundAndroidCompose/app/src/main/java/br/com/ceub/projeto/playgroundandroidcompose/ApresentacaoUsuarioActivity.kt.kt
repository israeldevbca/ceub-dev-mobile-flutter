package br.com.ceub.projeto.playgroundandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class ApresentacaoUsuarioActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CorCeub
                ) {


                }
            }

        }

    }
}

@Composable
fun CardApresentacao() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
        Text(
            text = "NOME",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Cargo",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun CardContato() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "fulano@gmail.com", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "+55 61 9999-88888", color = Color.White)
        }
    }
}


@Preview
@Composable
fun CardApresentacaoPreview() {
    PlaygroundAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = CorCeub
        ) {
            Column {
                CardApresentacao()
                CardContato()
            }


        }
    }
}
