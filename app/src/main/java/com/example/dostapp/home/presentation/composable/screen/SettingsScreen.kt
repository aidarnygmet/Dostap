package com.example.dostapp.home.presentation.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.dostapp.MyApp
import com.example.dostapp.R

@Composable
fun SettingsScreen(navigateToAuth: ()->Unit){
    val context = LocalContext.current
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp),
        color = MaterialTheme.colorScheme.background)  {
        Button(onClick = {
            val prefs = MyApp.appModule.prefs
            prefs
                .edit()
                .remove("jwt")
                .apply()
            navigateToAuth()
        }) {
            Text(text = context.getString(R.string.sign_out))
        }
    }
}