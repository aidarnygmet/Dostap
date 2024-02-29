package com.example.dostapp.screens

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dostapp.R
import com.example.dostapp.components.RectangleCard
import com.example.dostapp.components.SquareCard
import com.example.dostapp.data.EventCard
import com.example.dostapp.ui.theme.LightColorScheme
import com.example.dostapp.ui.theme.defTypography

@Composable
fun HomeScreen(){
    val context = LocalContext.current
    val eventCard = EventCard(
        name = "Футбол на Ботаническом", address = "Ботанический Парк, Астана", time ="Суббота, 24.10 в 17:00",
        rating = 4.5F, category = "Футбол",
        pic = R.drawable.ronaldo_big)
    val eventCard2 = EventCard(
        name = "Open Air на Expo", address = "EXPO 2017, Astana", time ="Пятница, 23.10 в 19:00",
        rating = 4.7F, category = "Open Air",
        pic = R.drawable.expo)
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
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ){
                Text(
                    text = context.getString(R.string.for_you),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = context.getString(R.string.view_everything),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            LazyRow(){
                items(5){item->
                    if(item%2==0){
                        SquareCard(eventCard = eventCard)
                    } else {
                        SquareCard(eventCard = eventCard2)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = context.getString(R.string.popular_nearby),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = context.getString(R.string.view_everything),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Column {
                for(i in 0 .. 5) {
                    if(i%2==0){
                        RectangleCard(eventCard = eventCard)
                    } else {
                        RectangleCard(eventCard = eventCard2)
                    }
                    Spacer(modifier = Modifier.size(15.dp))
                }
            }
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
        HomeScreen()
    }

}
