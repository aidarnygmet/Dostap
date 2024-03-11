package com.example.dostap.home.presentation.composable.screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.dostap.MyApp
import com.example.dostap.R
import com.yandex.mapkit.MapKitFactory

@Suppress("DEPRECATION")
@Composable
fun YandexMap(){
    val context = LocalContext.current
    var location by remember { mutableStateOf(Pair(0.0, 0.0)) }
    var recompose by remember { mutableIntStateOf(0) }
    Log.d("test", location.toString())
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    // Permission granted, update the location
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        getLocation(context){
                            location = it
                        }
                        return@rememberLauncherForActivityResult
                    }
                }
            })
//    if (hasLocationPermission(context)){
//        getLocation(context = context){
//            location = it
//        }
//    } else {
//        requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
//    }
    Column(
        modifier = Modifier. fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MapKitFactory.initialize(context)
        Text(text = "Location: Latitude: ${location.first} and Longitude: ${location.second}")
        Button(onClick = { recompose++ }) {
            Text(text = "recompose")
        }
        AndroidView(factory = {
            View.inflate(it, R.layout.yandex_map_layout, null)

        },
            modifier = Modifier.fillMaxSize(),
            update = {

            })
    }

}
private fun hasLocationPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}
private fun getLocation(context: Context, onCallback: (Pair<Double, Double>)->Unit) {
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ){
        MyApp.appModule.locationClient.lastLocation.addOnCompleteListener {
            if(it.isSuccessful){
                onCallback(Pair(it.result.latitude, it.result.longitude))
            }
        }

    } else {
        Log.d("test", "Location is not provided")
        Toast.makeText(context, "Location is not provided", Toast.LENGTH_LONG).show()
    }

}

//@Preview
//@Composable
//fun YandexMapPreview(){
//    YandexMap()
//}