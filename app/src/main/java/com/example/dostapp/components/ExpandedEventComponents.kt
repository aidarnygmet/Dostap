package com.example.dostapp.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostapp.R
import com.example.dostapp.data.EventCard
import com.example.dostapp.ui.theme.defTypography

@Composable
fun FirstRow(category: String, participants: String, rating: Float){
    val context = LocalContext.current
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Column {
            Text(text = context.getString(R.string.rating), style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.size(5.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.rating), contentDescription = "rating")
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = rating.toString(), style = MaterialTheme.typography.titleLarge)
            }
        }
        Row {
            Divider(color = Color.Gray, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))
            Spacer(modifier = Modifier.size(20.dp))
            Column {
                Text(text = context.getString(R.string.category), style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = category, style = MaterialTheme.typography.titleLarge)
            }
        }
        Row {
            Divider(color = Color.Gray, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))
            Spacer(modifier = Modifier.size(20.dp))
            Column {
                Text(text = context.getString(R.string.participants), style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = participants, style = MaterialTheme.typography.titleLarge)
            }
        }






    }
}
@Composable
fun Description(descr: String){
    val context = LocalContext.current
    Column {
        Text(text = context.getString(R.string.descr), style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = descr, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(horizontal = 5.dp))
    }
}
@Composable
fun Location(){
    val context = LocalContext.current
    Column {
        Text(text = context.getString(R.string.meet_location), style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.size(5.dp))
        Image(painter = painterResource(id = R.drawable.meeting_location), contentDescription = "meet", modifier = Modifier.fillMaxWidth()
        , contentScale = ContentScale.Crop)
    }
}
@Composable
fun ToTake(things: List<Things>){
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(things){item->
            ThingsToTake(thing = item)
        }
    }
}

data class Things (
    val pic: Int,
    val descr: String
)

@Composable
fun ThingsToTake(
    thing: Things
) {
    Row(modifier = Modifier
        .border(0.1.dp, Color.Gray, MaterialTheme.shapes.medium)
        .padding(5.dp)
    ) {
        Image(painter = painterResource(id = thing.pic), contentDescription = "thing")
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = thing.descr, style = MaterialTheme.typography.labelSmall)
    }
}
@Preview
@Composable
fun EEComponents(){
    val category = "Спорт"
    val participants = "10-20"
    val rating = 4.5F
    val descr = "Футбол в парке предлагает молодежи уникальную возможность собраться вместе, вдохновиться игрой и создать дружескую обстановку, в которой каждый может выразить свои спортивные навыки, весело провести время и насладиться активным общением."
    val things = listOf(
            Things(R.drawable.group, "Футбольный мяч"),
            Things(R.drawable.group, "Попить(По желанию)"),
            Things(R.drawable.group, "Поесть (По желанию)"),
            Things(R.drawable.group, "Хорошее Настроение"),
            Things(R.drawable.group, "Одежда"),
            Things(R.drawable.group, "Жел")
        )
    MaterialTheme(
        typography = defTypography
    ){
        Surface() {
            Column {
                FirstRow(category = category, participants = participants, rating = rating)
                Spacer(modifier = Modifier.size(20.dp))
                Description(descr = descr)
                Location()
                ToTake(things = things)
            }
        }

    }
}