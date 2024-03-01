package com.example.dostapp.home.presentation.composable.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostapp.home.presentation.composable.component.AboutProfile
import com.example.dostapp.home.presentation.composable.component.BasicProfileInfo
import com.example.dostapp.home.presentation.composable.component.TopBar

@Composable
fun ProfileScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp),
        color = MaterialTheme.colorScheme.background){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            TopBar()
            BasicProfileInfo()
            AboutProfile()
        }

    }
}

@Preview
@Composable
fun ProfilePreview(){
    ProfileScreen()
}
