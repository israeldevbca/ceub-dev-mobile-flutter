package br.com.ceub.projeto.playgroundandroidcompose.lista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.lista.data.PaisagensDatasource
import br.com.ceub.projeto.playgroundandroidcompose.lista.model.Paisagem
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.CorCeub
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class ListaImagensActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
//                    AppLista()
                    AppGrid()
                }
            }
        }
    }

}

@Composable
fun AppLista() {
//    PaisagemCard(paisagem = Paisagem("Teste", R.drawable.image1))
    PaisagemLista(lista = PaisagensDatasource().consultarPaisagens())
}

@Composable
fun AppGrid(modifier: Modifier = Modifier.padding(all = 8.dp)) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(PaisagensDatasource().consultarPaisagens()) { paisagem ->
            PaisagemCard(paisagem = paisagem)
        }
    }
}

@Composable
fun PaisagemLista(
    lista: List<Paisagem>,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(all = 16.dp)
) {
    LazyColumn(modifier = modifier) {
        items(lista) { item: Paisagem ->
            PaisagemCard(
                paisagem = item,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun PaisagemCard(paisagem: Paisagem, modifier: Modifier = Modifier.fillMaxWidth()) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = paisagem.idImage),
                contentDescription = paisagem.descricao,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = paisagem.descricao,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun AppListaPreview() {
//    AppLista()
    AppGrid()
}
