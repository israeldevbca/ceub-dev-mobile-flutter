package br.com.ceub.projeto.playgroundandroidcompose.lista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.lista.data.PaisagemDataSource
import br.com.ceub.projeto.playgroundandroidcompose.lista.model.Paisagem
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class ListaPaisagemActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {

                }

            }
        }

    }

    @Composable
    fun AppLista(){
        //        PaisagemCard(paisagem = Paisagem(R.drawable.image1,  "imagem 1"),
        //          modifier = Modifier.fillMaxWidth() )
    PaisagemLista(lista = PaisagemDataSource().consultarPaisagem())
    }

    @Composable
    fun PaisagemCard(paisagem: Paisagem, modifier: Modifier) {
       Card(modifier = modifier) {
           Column {
               Image(painter = painterResource(id = paisagem.idImg),
                   contentDescription = paisagem.descricao, modifier = Modifier
                       .fillMaxWidth()
                       .height(200.dp),
                   contentScale = ContentScale.Crop
               )
               Text(text = paisagem.descricao,
                   modifier = modifier.padding(all = 16.dp),
                   style = MaterialTheme.typography.headlineSmall)
           }
       }
    }

    @Composable
    fun PaisagemLista(lista : List<Paisagem>, modifier: Modifier = Modifier.padding(16.dp)) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = modifier.fillMaxWidth()
        ) {
            items(lista) { paisagem ->
                PaisagemCard(paisagem = paisagem);
            }
        }
    }
    // erro erro erro erro erro
   @Preview
   @Composable
   fun PaisagemCard(paisagem: Paisagem) {
       Card {
       }
   }