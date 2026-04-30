package edu.uade.primerparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.uade.primerparcial.logic.PokemonViewModel
import edu.uade.primerparcial.ui.PokemonListScreen


/*Capa de conexión (Route). Desacopla como ingresan los pókemon a la vista.
 Obtiene el estado desde el ViewModel y lo pasa a la UI (PokemonListScreen).
*/
@Composable
fun PokemonListScreenRoute(
    viewModel: PokemonViewModel = viewModel()
) {
    val pokemons by viewModel.pokemons.collectAsState()
    PokemonListScreen(pokemons = pokemons)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonListScreenRoute()
        }
    }
}
