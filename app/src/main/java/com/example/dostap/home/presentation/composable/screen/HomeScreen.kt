package com.example.dostap.home.presentation.composable.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostap.R
import com.example.dostap.home.data.model.EventCard
import com.example.dostap.home.data.model.Promo
import com.example.dostap.home.presentation.composable.component.ArticleBlock
import com.example.dostap.home.presentation.composable.component.ChooseLocationBlock
import com.example.dostap.home.presentation.composable.component.NearestYourLocationBlock
import com.example.dostap.home.presentation.composable.component.PopularNearbyBlock
import com.example.dostap.home.presentation.composable.component.PromoBlock
import com.example.dostap.home.presentation.composable.component.SpecialForYouBlock
import com.example.dostap.ui.theme.LightColorScheme
import com.example.dostap.ui.theme.defTypography

@Composable
fun HomeScreen(onClick: (EventCard)->Unit){
    val context = LocalContext.current
    val eventCard = EventCard(
        name = "Футбол на Ботаническом", address = "Ботанический Парк, Астана", time ="Суббота, 24.10 в 17:00",
        rating = 4.5F, category = "Футбол",
        pic = R.drawable.ronaldo_big)
    val eventCard2 = EventCard(
        name = "Open Air на Expo", address = "EXPO 2017, Astana", time ="Пятница, 23.10 в 19:00",
        rating = 4.7F, category = "Open Air",
        pic = R.drawable.expo)
    val eventCards = listOf(
        eventCard,
        eventCard2,
        eventCard,
        eventCard2,
        eventCard,
        eventCard2,
    )
    val promo = Promo(
        title = "Astana Hikes",
        points = listOf(
            "-20% на первый тур",
            "C 1.01.2024 до 1.06.2024"
        )

    )
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp),
        color = MaterialTheme.colorScheme.background) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)){
            Text(
                text = context.getString(R.string.location),
                style = MaterialTheme.typography.bodySmall
                )
            Text(
                text = "Астана, Казахстан",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.size(20.dp))
            SearchBar(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.size(20.dp))
            SpecialForYouBlock(eventCards = eventCards, onClick = onClick)
            PopularNearbyBlock(eventCards = eventCards)
            PromoBlock(promo)
            NearestYourLocationBlock(eventCards = eventCards, onClick = {})
            ChooseLocationBlock(eventCards = eventCards, onClick = {})
            ArticleBlock(eventCards = eventCards, onClick = {})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier){

    val context = LocalContext.current
    var searchText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier,
        value = searchText,
        onValueChange = {searchText = it},
        shape = RoundedCornerShape(20.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null)},
        placeholder = { Text(text = context.getString(R.string.search))}
    )
}
@Preview
@Composable
fun HomeScreenPreview(){
    MaterialTheme(
        typography = defTypography,
        colorScheme = LightColorScheme
    ){
        HomeScreen(onClick = {})
    }

}
