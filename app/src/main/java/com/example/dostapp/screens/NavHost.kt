package com.example.dostapp.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.SignInScreen.route){
        composable(Screen.SignInScreen.route){
            val context = LocalContext.current
            SignInScreen(onGoogleSignInClicked = { }, onSignInClicked = {email, password->
                Toast.makeText(context, "sign in", Toast.LENGTH_LONG).show()
            }, onSignUpClicked = {
                navController.navigate(Screen.SignUpScreen.route)
            })
        }
        composable(Screen.SignUpScreen.route){
            val context = LocalContext.current
            SignUpScreen(context = context, onBackClicked = { navController.navigate(Screen.SignInScreen.route) }, onButtonClicked = {email,username,password->

            })
        }
    }
}