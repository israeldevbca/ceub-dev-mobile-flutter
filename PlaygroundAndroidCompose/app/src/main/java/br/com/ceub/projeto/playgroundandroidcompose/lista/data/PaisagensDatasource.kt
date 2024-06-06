package br.com.ceub.projeto.playgroundandroidcompose.lista.data

import br.com.ceub.projeto.playgroundandroidcompose.R
import br.com.ceub.projeto.playgroundandroidcompose.lista.model.Paisagem

class PaisagensDatasource {

    fun consultarPaisagens(): List<Paisagem> {
        val listaPaisagem = listOf(
            Paisagem("Paisagem 1", R.drawable.image1),
            Paisagem("Paisagem 2", R.drawable.image2),
            Paisagem("Paisagem 3", R.drawable.image3),
            Paisagem("Paisagem 4", R.drawable.image4),
            Paisagem("Paisagem 5", R.drawable.image5),
            Paisagem("Paisagem 6", R.drawable.image6),
            Paisagem("Paisagem 7", R.drawable.image7),
            Paisagem("Paisagem 8", R.drawable.image8),
            Paisagem("Paisagem 9", R.drawable.image9),
            Paisagem("Paisagem 10", R.drawable.image10),
        )
        return listaPaisagem
    }
}
