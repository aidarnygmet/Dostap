package com.example.dostap.home.presentation.composable.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dostap.home.data.model.ProfileData
import com.example.dostap.home.presentation.composable.component.BasicProfileInfo
import com.example.dostap.home.presentation.composable.component.TopBar

@Composable
fun ProfileScreen(profileData: ProfileData, navController: NavController){
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
            TopBar(navController)
            BasicProfileInfo(profile = profileData)
        }

    }
}


