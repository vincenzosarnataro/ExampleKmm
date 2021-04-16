package it.sarni.ipakmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.google.accompanist.glide.GlideImage
import it.sarni.ipakmm.android.ui.theme.IpaKMMTheme
import it.sarni.ipakmm.domain.entity.Beer
import it.sarni.ipakmm.presentation.features.beer.BeerViewModel
import it.sarni.ipakmm.presentation.models.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    private val beerViewModel: BeerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IpaKMMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold (topBar = { TopAppBar(title = { Text(text = "Beers") }) },content ={BuildHome(viewModel = beerViewModel)})
                }
            }
        }
    }
}

@Composable
fun BuildHome(viewModel: BeerViewModel) {
    val state = viewModel.loadBeersState.collectAsState(initial = null)
    when (state.value) {
        is UiState.Error -> {
        }
        is UiState.Loading -> {

        }
        is UiState.Success -> BuildBeers(list = state.value?.data?.listBeers.orEmpty())
    }
}



@Composable
fun BuildBeers(list: List<Beer>) {
    LazyColumn (    verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(20.dp)){
        items(list) { ipa ->
            BuildIpaCard(ipa = ipa)
            Divider()

        }

    }
}

@Composable
fun BuildIpaCard(ipa: Beer) {
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            GlideImage(
                data = ipa.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(ipa.name,fontSize = 15.sp,fontWeight = FontWeight.Bold)
            }
        }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IpaKMMTheme {
        BuildIpaCard(
            ipa = Beer(
                id = 2,
                imageUrl = "",
                name = "IPA",
                description = "Description very long",
                abv = null,
                ibu = null,
                firstBrewed = "",
                brewersTips = ""
            )
        )
    }
}