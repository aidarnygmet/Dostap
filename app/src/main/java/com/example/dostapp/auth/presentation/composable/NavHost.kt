package com.example.dostapp.auth.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.dostapp.R
import com.example.dostapp.core.data.Screen
import com.example.dostapp.home.presentation.composable.screen.MainScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "auth"){
        navigation(startDestination = Screen.OnBoardingScreen.withArgs("1"), route = "auth"){
            composable(Screen.SignInScreen.route){
                SignInScreen(onGoogleSignInClicked = { }, onSignInClicked = {email, password->
                    navController.navigate("main_screen"){
                        popUpTo("auth"){
                            inclusive = true
                        }
                    }

                }, onSignUpClicked = {
                    navController.navigate(Screen.SignUpScreen.route)
                })
            }
            composable(Screen.SignUpScreen.route){
                SignUpScreen(onSignInClicked = { navController.navigate(Screen.SignInScreen.route) }, onSignUpClicked = { a, b, c->

                }, onGoogleSignInClicked = {})
            }
            composable(Screen.OnBoardingScreen.route+"/1"){
                val context = LocalContext.current
                val params = OnBoardingData(
                    label = context.getString(R.string.onBoarding1_label),
                    body = context.getString(R.string.onBoarding1_body),
                    pic = R.drawable.devices,
                    button = "Далее",
                    dot = 1,
                    buttonClicked = {navController.navigate(Screen.OnBoardingScreen.withArgs("2"))}
                )
                OnBoarding(params)
            }
            composable(Screen.OnBoardingScreen.route+"/2"){
                val context = LocalContext.current
                val params = OnBoardingData(
                    label = context.getString(R.string.onBoarding2_label),
                    body = context.getString(R.string.onBoarding2_body),
                    pic = R.drawable.party,
                    button = "Далее",
                    dot = 2,
                    buttonClicked = {navController.navigate(Screen.OnBoardingScreen.withArgs("3"))}
                )
                OnBoarding(params)
            }
            composable(Screen.OnBoardingScreen.route+"/3"){
                val context = LocalContext.current
                val params = OnBoardingData(
                    label = context.getString(R.string.onBoarding3_label),
                    body = context.getString(R.string.onBoarding3_body),
                    pic = R.drawable.searching,
                    button = "Зарегистрироваться",
                    dot = 3,
                    buttonClicked = {navController.navigate(Screen.SignUpScreen.route)}
                )
                OnBoarding(params)
            }
        }
        navigation(startDestination = Screen.MainScreen.route, route = "main"){
            composable(Screen.MainScreen.route){
                MainScreen()
            }

        }


    }
}