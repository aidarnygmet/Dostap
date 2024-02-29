package com.example.dostapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dostapp.R
import com.example.dostapp.data.EventCard
import com.example.dostapp.ui.theme.LightColorScheme
import com.example.dostapp.ui.theme.defTypography

@Composable
fun SquareCard(
    modifier: Modifier = Modifier.size(width = 200.dp, height = 260.dp),
    eventCard: EventCard
){
    OutlinedCard(shape= RoundedCornerShape(20.dp) ,modifier = modifier.size(width = 200.dp, height = 260.dp), border = BorderStroke(0.5.dp, color = Color(0xFFAFAFAF))) {
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
fun RectangleCard(modifier: Modifier = Modifier.size(width = 380.dp, height = 90.dp),
                  eventCard: EventCard){
        OutlinedCard(shape= RoundedCornerShape(20.dp) ,modifier = modifier, border = BorderStroke(0.5.dp, color = Color(0xFFAFAFAF))) {
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
    MaterialTheme(
        typography = defTypography,
        colorScheme = LightColorScheme
    ){
        RectangleCard(eventCard = eventCard)
    }


}