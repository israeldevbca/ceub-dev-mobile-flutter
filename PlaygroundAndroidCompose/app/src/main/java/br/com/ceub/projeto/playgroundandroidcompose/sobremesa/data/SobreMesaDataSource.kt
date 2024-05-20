package br.com.ceub.projeto.playgroundandroidcompose.sobremesa.data

import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.sobremesa.model.Sobremesa

object SobreMesaDataSource {

    val dessertList: List<Sobremesa> = listOf(
        Sobremesa(R.drawable.cupcake, 5.0, 0),
        Sobremesa(R.drawable.donut, 10.0, 5),
        Sobremesa(R.drawable.eclair, 15.0, 20),
        Sobremesa(R.drawable.froyo, 30.0, 50),
        Sobremesa(R.drawable.gingerbread, 50.0, 100),
        Sobremesa(R.drawable.honeycomb, 100.0, 200),
        Sobremesa(R.drawable.icecreamsandwich, 500.0, 500),
        Sobremesa(R.drawable.jellybean, 1000.0, 1000),
        Sobremesa(R.drawable.kitkat, 2000.0, 2000),
        Sobremesa(R.drawable.lollipop, 3000.0, 4000),
        Sobremesa(R.drawable.marshmallow, 4000.0, 8000),
        Sobremesa(R.drawable.nougat, 5000.0, 16000),
        Sobremesa(R.drawable.oreo, 6000.0, 20000)
    )

}
