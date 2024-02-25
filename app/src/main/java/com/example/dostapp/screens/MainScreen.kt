package com.example.dostapp.screens

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.dostapp.PingViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Composable
fun MainScreen(viewModel: PingViewModel){

    val text by remember {
        mutableStateOf("Hello World")
    }


    Column {
        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.ping()
                viewModel.ping.value?.let { Log.d("test", it) }
            }



        }) {
            Text(text = "Ping")
        }
        Text(text = text)
    }



}