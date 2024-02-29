package com.example.dostapp.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dostapp.R
import com.example.dostapp.data.EventCard
import com.example.dostapp.ui.theme.LightColorScheme
import com.example.dostapp.ui.theme.defTypography


@Composable
fun ExpandedEventScreen(eventCard: EventCard, navController: NavController){
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
            ) {
                Image(modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = eventCard.pic),
                    contentDescription = "event",
                    contentScale = ContentScale.Crop)
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painter = painterResource(id = R.drawable.back), contentDescription = "back",
                        modifier = Modifier.clickable { navController.popBackStack() })
                    Image(painter = painterResource(id = R.drawable.favourite), contentDescription = "fav")
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.Bottom
                    ){
                    Text(text = eventCard.name, style = MaterialTheme.typography.displayLarge, color = Color.White)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.location_white), contentDescription = "loc", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = eventCard.address, style = MaterialTheme.typography.titleMedium, color = Color.White)
                    }
                    Row {
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = eventCard.time, style = MaterialTheme.typography.titleMedium, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)){
                Column {
                    Text(text = context.getString(R.string.category))
                    Text(text = eventCard.category)
                }
                Spacer(modifier = Modifier.size(20.dp))
                Divider(color = Color.Gray, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp))
                Spacer(modifier = Modifier.size(20.dp))
                Image(painter = painterResource(id = R.drawable.calendar), contentDescription = "calendar")
                Spacer(modifier = Modifier.size(40.dp))
                Column {
                    Text(text = context.getString(R.string.participants))
                    Text(text = eventCard.category)
                }

            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)){
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "organ")
                Column {
                    Text(text = context.getString(R.string.organizer))
                    Text(text = eventCard.category)
                }
                Spacer(modifier = Modifier.size(20.dp))
                Divider(color = Color.Gray, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp))
                Spacer(modifier = Modifier.size(20.dp))
                Column {
                    Text(text = context.getString(R.string.going))
                    Text(text = eventCard.category)
                }

            }
            Text(text = context.getString(R.string.descr))
            Text(text = "Placeholder description")
            Text(text = context.getString(R.string.place))
            //map composable
            Text(text = context.getString(R.string.things))
            ThingsToTake(pic = R.drawable.group, descr = context.getString(R.string.football))
        }
    }

}
@Composable
fun ThingsToTake(
        pic: Int,
        descr: String
) {
    Row(modifier = Modifier
        .border(0.1.dp, Color.Gray, MaterialTheme.shapes.medium)
        .padding(5.dp)
    ) {
        Image(painter = painterResource(id = pic), contentDescription = "thing")
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = descr)
    }
}
//@Preview
//@Composable
//fun ExpandedEventPreview(){
//    val eventCard = EventCard(
//        name = "Футбол на Ботаническом", address = "Ботанический Парк, Астана", time ="Суббота, 24.10 в 17:00",
//        rating = 4.5F, category = "Футбол",
//        pic = R.drawable.ronaldo_big)
//    val eventCard2 = EventCard(
//        name = "Open Air на Expo", address = "EXPO 2017, Astana", time ="Пятница, 23.10 в 19:00",
//        rating = 4.7F, category = "Open Air",
//        pic = R.drawable.expo)
//    MaterialTheme(
//        typography = defTypography,
//        colorScheme = LightColorScheme
//    ){
//        ExpandedEventScreen(eventCard = eventCard)
//    }
//}
