package br.com.ceub.projeto.exemplo.navigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.exemplo.navigation.R
import br.com.ceub.projeto.exemplo.navigation.data.CupcakeDataSource
import br.com.ceub.projeto.exemplo.navigation.ui.theme.AppCupCakeTheme

@Composable
fun InicioVendaPage(
    qtdOpcoes : List<Pair<String, Int>>,
    modifier: Modifier
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,) {
        Spacer(modifier = Modifier.size(32.dp))
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = null,
            modifier = Modifier.width(300.dp))
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = "Cupcakes", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            qtdOpcoes.forEach { qtdPedido ->
                Button(onClick = { /*TODO*/ },  modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = "${qtdPedido.first} CupCake")
                }

            }
        }

    }

}

@Preview
@Composable
fun InicioVendaPagePreview() {
    AppCupCakeTheme {
        InicioVendaPage(
            qtdOpcoes = CupcakeDataSource.quantidades,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp))
    }
}
