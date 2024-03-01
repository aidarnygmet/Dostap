package com.example.dostapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.example.dostapp.R

@Composable
fun TopBar(){
    val context = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = context.getString(R.string.my_profile), style = MaterialTheme.typography.titleLarge)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.edit), contentDescription = "edit")
            Spacer(modifier = Modifier.size(10.dp))
            Image(painter = painterResource(id = R.drawable.settings), contentDescription = "settings")
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}
@Composable
fun BasicProfileInfo(){
    val context = LocalContext.current
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ronaldo_big),
                contentDescription = "profilepic",
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = context.getString(R.string.profile_name))
                    Text(text = "Samat")
                }
                Column {
                    Text(text = context.getString(R.string.profile_age))
                    Text(text = "23")
                }
                Column {
                    Text(text = context.getString(R.string.profile_cities))
                    Text(text = "Астана, Казахстан")
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }

}
@Composable
fun AboutProfile(){
    val list = listOf(
        "Ценитель старого кино",
        "Путешественник, любитель кофе и начинающий шеф-повар",
        "KIMEP, 2022"
    )
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = context.getString(R.string.about_profile))

        Column {
            list.forEach{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.Black, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = it)
                }
            }
        }
    }


}
@Composable
fun Interests(){

}
@Composable
fun EventsProfile(){

}
@Preview
@Composable
fun ProfilePreview(){
    AboutProfile()
}