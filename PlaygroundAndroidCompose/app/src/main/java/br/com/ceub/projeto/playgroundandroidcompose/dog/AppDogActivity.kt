package br.com.ceub.projeto.playgroundandroidcompose.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.dog.model.Dog
import br.com.ceub.projeto.playgroundandroidcompose.dog.model.listaDogs
import br.com.ceub.projeto.playgroundandroidcompose.ui.theme.PlaygroundAndroidComposeTheme

class AppDogActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAndroidComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppDog()
                }
            }
        }
    }
}

@Composable
fun AppDog() {
    //Scaffold - Add quando for adicionar a TopBar
    Scaffold(topBar = { DogTopAppBar() }) { it ->
        LazyColumn(contentPadding = it) {
            items(listaDogs) { dog ->
                DogItem(dog = dog, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun SobreDog(descricao: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Sobre:",
            style = MaterialTheme.typography.labelSmall)
        Text(text = descricao,
            style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {

    var iconeExpandido by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 70.dp, bottomStart = 35.dp, topEnd = 16.dp)
    ) {
        //Column só depois para expanndido
        Column(modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMedium)
        )){
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = modifier
                        .size(75.dp)
                        .padding(16.dp)
                        .clip(MaterialTheme.shapes.large),
                    painter = painterResource(id = dog.img),
                    contentDescription = dog.nome,
                    contentScale = ContentScale.Crop
                )
                InfoDog(dog = dog)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { iconeExpandido = !iconeExpandido }) {
                    Icon(
                        imageVector = if (iconeExpandido) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            if(iconeExpandido) {
                SobreDog(descricao = dog.hoobie,
                    modifier = Modifier.padding(start = 32.dp,
                        bottom = 16.dp))
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.icon_dog),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Text(
                text = "App Dog",
                style = MaterialTheme.typography.displaySmall,
            )
        }
    }, modifier = modifier)
}

@Composable
fun InfoDog(dog: Dog, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = dog.nome,
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = "Idade: ${dog.idade}", style = MaterialTheme.typography.bodyLarge)
    }
}


@Preview
@Composable
fun AppDogPreview() {
    PlaygroundAndroidComposeTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            AppDog()
        }
    }
}
