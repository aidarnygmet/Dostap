package com.example.dostap.home.presentation.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dostap.R
import com.example.dostap.core.data.Screen
import com.example.dostap.home.data.model.ProfileData

@Composable
fun TopBar(navController:NavController){
    val context = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = context.getString(R.string.my_profile), style = MaterialTheme.typography.titleLarge)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.edit), contentDescription = "edit")
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SettingsScreen.route)
                },
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "settings")
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}
@Composable
fun BasicProfileInfo(profile: ProfileData){
    val context = LocalContext.current
    Column {
    Row {
        Image(painter = painterResource(id = profile.profilePic),
            contentDescription = "profilePic",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
            )
        Spacer(modifier = Modifier.size(16.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = profile.username)
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = context.getString(R.string.friends))
                    Text(text = profile.friendsCount.toString())
                }
            }

        }
    }
        Column {
            Text(text = context.getString(R.string.profile_name))
            Text(text = profile.firstName)
            Text(text = context.getString(R.string.profile_age))
            Text(text = profile.age.toString())
            Text(text = context.getString(R.string.profile_cities))
            Text(text = profile.city)
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = context.getString(R.string.about_profile))
            Divider(modifier = Modifier.fillMaxWidth())
            for (s in profile.aboutUser) {
                Text(text = s)
            }
        }
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
    Column() {
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
