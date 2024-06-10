package br.com.ceub.projeto.exemplo.navigation.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel;
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.ceub.projeto.exemplo.navigation.data.CupcakeDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
    telaAtual : PagesCupcake,
    podeVoltar : Boolean,
    ir : () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Text(text = telaAtual.titulo,)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon =  {
            if(podeVoltar){
                IconButton(onClick = ir) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Voltar"
                    )
            }
        }}
    )
}

@Composable
fun AppCupcake(
    viewModel: VendaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    ) {

    val voltarState by navController.currentBackStackEntryAsState()
    val telaAtual = PagesCupcake.valueOf(
        voltarState?.destination?.route ?: PagesCupcake.inicio.name
    )

    Scaffold(
        topBar = {
            CupcakeAppBar(
                podeVoltar = navController.previousBackStackEntry != null,
                ir = { navController.navigateUp() },
                telaAtual = telaAtual,
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PagesCupcake.inicio.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = PagesCupcake.inicio.name) {
                InicioVendaPage(
                    qtdOpcoes = CupcakeDataSource.quantidades,
                    onProximoBotaoClick = {
                        viewModel.setQuantidade(it)
                        //Navegar para a tela de sabores
                        navController.navigate(PagesCupcake.sabores.name)
                    },
                )
            }

            composable(route = PagesCupcake.sabores.name) {
                SelecionarOpcoesPage(
                    subTotal = uiState.valor,
                    onProximoBotaoClick = { navController.navigate(PagesCupcake.resumo.name) },
                    onCancelarClick = { cancelarVendaENavegarParaInicio(viewModel, navController) },
                    opcoes = CupcakeDataSource.sabores,
                    onSelecionarOpcao = { opcaoSelecionada ->
                        viewModel.setSabor(opcaoSelecionada) },
                    modifier = Modifier.fillMaxSize())
            }

            composable(route = PagesCupcake.resumo.name) {
                val context : Context = LocalContext.current
                ResumoVendaPage(
                    vendaUiState = uiState,
                    modifier = Modifier.fillMaxSize(),
                    onCancelarClick = {
                                      cancelarVendaENavegarParaInicio(viewModel, navController)
                    },
                    onFinalizarCLick = {titulo, resumo ->
                        compartilharPedido(
                            context = context,
                            assunto = titulo,
                            resumo = resumo, )
                    })
            }

        }
    }
}

private fun cancelarVendaENavegarParaInicio(
    viewModel: VendaViewModel,
    navController: NavHostController
) {
    viewModel.reiniciarVenda()
    //Navegar para trás para a tela de início
    navController.popBackStack(PagesCupcake.inicio.name, inclusive = false)
}

private fun compartilharPedido(context: Context, assunto: String, resumo : String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, assunto)
        putExtra(Intent.EXTRA_TEXT, resumo)
    }
    context.startActivity(Intent.createChooser(intent, "Pedido Cupcake"))
}

@Composable
fun SubTotalComponent(subTotal: String) {
    Text(
        text = "SubTotal ${subTotal}",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.End)
    )
}

enum class PagesCupcake(val titulo : String) {
    inicio("App Cupcake"),
    sabores( "Escolha os sabores"),
    resumo("Resumo do pedido"),
}
