package com.example.dostapp.home.presentation.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostapp.R
import com.example.dostapp.home.data.model.EventCard
import com.example.dostapp.home.data.model.Promo
import com.example.dostapp.ui.theme.LightColorScheme
import com.example.dostapp.ui.theme.defTypography

@Composable
fun SquareCard(
    modifier: Modifier = Modifier,
    eventCard: EventCard,
    onClick: (EventCard)->Unit
){
    OutlinedCard(
        shape= RoundedCornerShape(20.dp),
        modifier = modifier
            .size(width = 200.dp, height = 260.dp)
            .clickable {
                onClick(eventCard)
            },
        border = BorderStroke(0.5.dp, color = Color(0xFFAFAFAF))) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)) {
            Image(painter = painterResource(id = eventCard.pic), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(20.dp)), contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
            ){
                Text(text = eventCard.category, style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFF9F9F9))
                        .padding(horizontal = 10.dp, vertical = 3.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = eventCard.name, style = MaterialTheme.typography.titleMedium)
                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.rating), contentDescription = "rating")
                    Text(text = eventCard.rating.toString(), style = MaterialTheme.typography.bodySmall)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.location), contentDescription = "loc", modifier = Modifier.size(12.dp))
                Spacer(modifier = Modifier.size(2.dp))
                Text(text = eventCard.address, style = MaterialTheme.typography.labelSmall)
            }
            Row {
                Spacer(modifier = Modifier.size(14.dp))
                Text(text = eventCard.time, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
@Composable
fun RectangleCard(modifier: Modifier = Modifier,
                  eventCard: EventCard
){
        OutlinedCard(shape= RoundedCornerShape(20.dp) ,modifier = modifier.size(width = 380.dp, height = 90.dp), border = BorderStroke(0.5.dp, color = Color(0xFFAFAFAF))) {
            Row(modifier = Modifier) {
                Image(painter = painterResource(id = eventCard.pic), contentDescription = "",
                    modifier = Modifier
                        .size(90.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(20.dp)), contentScale = ContentScale.Crop)

                Column (modifier = Modifier
                    .fillMaxHeight()
                    .padding(5.dp), verticalArrangement = Arrangement.SpaceEvenly){
                    Row {
                        Text(text = eventCard.name, style = MaterialTheme.typography.headlineMedium)
                    }
                    Row {
                        Text(text = eventCard.category, style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .border(1.dp, Color(0xFFAFAFAF), RoundedCornerShape(6.dp))
                                .padding(horizontal = 10.dp, vertical = 3.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp), verticalAlignment = Alignment.CenterVertically
                    , horizontalArrangement = Arrangement.SpaceBetween){
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.location), contentDescription = "loc", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(text = eventCard.address, style = MaterialTheme.typography.labelSmall)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.rating), contentDescription = "rating")
                            Text(text = eventCard.rating.toString(), style = MaterialTheme.typography.bodyLarge)
                        }

                    }
                }
            }

        }
}
@Composable
fun SpecialForYouBlock(
    eventCards: List<EventCard>,
    onClick: (EventCard) -> Unit
){
    val context = LocalContext.current
    Column {
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
            items(eventCards){item->
                SquareCard(eventCard = item, onClick = {onClick(it)})
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}
@Composable
fun PopularNearbyBlock(eventCards: List<EventCard>){
    val context = LocalContext.current
    Column {
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
            eventCards.forEach {
                RectangleCard(eventCard = it)
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}
@Composable
fun PromoBox(promo: Promo){
    val context = LocalContext.current
    OutlinedCard(
        shape= RoundedCornerShape(20.dp),
        border = BorderStroke(0.5.dp, color = Color(0xFFAFAFAF)),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3.42f),

        ){
        Row {
            Image(painter = painterResource(id = R.drawable.promo_image), contentDescription = "promo_image",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(.36f),
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color(0xFF1A8EEA))
                .padding(horizontal = 30.dp, vertical = 5.dp)) {
                Text(text = promo.title)
                promo.points.forEach {
                    Text(text = "* $it")
                }
                Text(text = "*"+context.getString(R.string.details))
            }
            }
    }
}
@Composable
fun PromoBlock(promo: Promo){
    val context = LocalContext.current
    Column {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.fillMaxWidth(.6f),
                text = context.getString(R.string.promo),
                style = MaterialTheme.typography.headlineLarge
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        PromoBox(promo)
    }
}
@Composable
fun NearestCard(){

}
@Composable
fun NearestYourLocationBlock(
    eventCards: List<EventCard>,
    onClick: () -> Unit
){
    val context = LocalContext.current
    Column {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.fillMaxWidth(.6f),
                text = context.getString(R.string.nearest),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = context.getString(R.string.view_everything),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyRow(){
            items(eventCards){item->
                SquareCard(eventCard = item, onClick = {})
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}
@Composable
fun ChooseLocationBlock(
    eventCards: List<EventCard>,
    onClick: () -> Unit
){
    val context = LocalContext.current
    Column {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.fillMaxWidth(.6f),
                text = context.getString(R.string.choose_location),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = context.getString(R.string.view_everything),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyRow(){
            items(eventCards){item->
                SquareCard(eventCard = item, onClick = {  })
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}
@Composable
fun ArticleBlock(
    eventCards: List<EventCard>,
    onClick: () -> Unit
){
    val context = LocalContext.current
    Column {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.fillMaxWidth(.6f),
                text = context.getString(R.string.article),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = context.getString(R.string.view_everything),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyRow(){
            items(eventCards){item->
                SquareCard(eventCard = item, onClick = {})
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}
@Preview
@Composable
fun SquaredCardPreview(){
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
    MaterialTheme(
        typography = defTypography,
        colorScheme = LightColorScheme
    ){
        Surface {
            PromoBox(promo)
        }
        //RectangleCardColumn(eventCards = eventCards)

    }


}