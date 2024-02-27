package com.example.dostapp.screens

import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dostapp.PingViewModel
import com.example.dostapp.R

@Composable
fun Navigation(navController: NavHostController, viewModel: PingViewModel){
    navController.addOnDestinationChangedListener { _, destination, _ ->
        Log.d("test", "Navigated to ${destination.route}")
    }
    NavHost(navController = navController, startDestination = "on_boarding/3"){
        composable(Screen.SignInScreen.route){
            val context = LocalContext.current
            SignInScreen(onGoogleSignInClicked = { }, onSignInClicked = {email, password->
                Toast.makeText(context, "sign in", Toast.LENGTH_LONG).show()
                navController.navigate(Screen.MainScreen.route)
            }, onSignUpClicked = {
                navController.navigate(Screen.SignUpScreen.route)
            })
        }
        composable(Screen.SignUpScreen.route){
            val context = LocalContext.current
            SignUpScreen(context = context, onSignInClicked = { navController.navigate(Screen.SignInScreen.route) }, onSignUpClicked = {a,b,c->

            }, onGoogleSignInClicked = {})
        }
        composable(Screen.MainScreen.route){
            MainScreen(viewModel)
        }
        composable(route=Screen.OnBoardingScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
            ){entry->
            val context = LocalContext.current
            val id = entry.arguments?.getString("id")
            var params: OnBoardingData
            if (id != null) {
                Log.d("test", id)
            } else {
                Log.d("test", "id is null")
            }
            when (id) {
                "1" -> {
                    params = OnBoardingData(
                        label = context.getString(R.string.onBoarding2_label),
                        body = context.getString(R.string.onBoarding2_body),
                        pic = R.drawable.party,
                        button = "Далее",
                        dot = 2,
                        buttonClicked = {navController.navigate(Screen.OnBoardingScreen.withArgs("2"))}
                    )
                }
                "2" -> {
                    params =
                    OnBoardingData(
                        label = context.getString(R.string.onBoarding3_label),
                        body = context.getString(R.string.onBoarding3_body),
                        pic = R.drawable.searching,
                        button = "Зарегистрироваться",
                        dot = 3,
                        buttonClicked = {navController.navigate(Screen.SignUpScreen.route)}
                    )
                }
                else -> {
                    params =
                    OnBoardingData(
                        label = context.getString(R.string.onBoarding1_label),
                        body = context.getString(R.string.onBoarding1_body),
                        pic = R.drawable.devices,
                        button = "Далее",
                        dot = 1,
                        buttonClicked = {navController.navigate(Screen.OnBoardingScreen.withArgs("1"))}
                    )
                }
            }
            onBoarding(params)
        }
    }
}