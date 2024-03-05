package com.example.dostapp.home.presentation.composable.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostapp.R
import com.example.dostapp.auth.data.model.Category
import com.example.dostapp.home.data.model.ProfileData
import com.example.dostapp.home.presentation.composable.component.BasicProfileInfo
import com.example.dostapp.home.presentation.composable.component.TopBar

@Composable
fun ProfileScreen(profileData: ProfileData){
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            TopBar()
            BasicProfileInfo(profile = profileData)
        }

    }
}

@Preview
@Composable
fun ProfilePreview(){
    val test = ProfileData(
        username="username.xyz",
        profilePic = R.drawable.ronaldo,
        age = 22,
        city = "Astana",
        firstName = "Дос",
        friendsCount = 15,
        aboutUser = listOf(
            "Ценитель старого кино",
            "Путешественник, любитель кофе и кулинарный энтузиаст",
            "NU, 2022",
        ),
        interests = listOf(
            Category.Chess,
            Category.Box,
            Category.Skates
        )
    )
    ProfileScreen(test)
}
