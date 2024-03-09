package com.example.dostap.auth.presentation.composable

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.dostap.MyApp
import com.example.dostap.R
import com.example.dostap.auth.data.model.AuthResult
import com.example.dostap.auth.presentation.viewmodel.AuthViewModel
import com.example.dostap.auth.presentation.viewmodel.viewModelFactory
import com.example.dostap.core.data.Screen
import com.example.dostap.home.presentation.composable.screen.MainScreen


@Composable
fun Navigation(navController: NavHostController){
    val viewModel = viewModel<AuthViewModel>(
        factory = viewModelFactory {
            AuthViewModel(MyApp.appModule.authRepository)
        }
    )
    NavHost(navController = navController, startDestination = "auth"){
        navigation(startDestination = Screen.LoadingScreen.route, route = "auth"){
            composable(Screen.SignInScreen.route){
                SignInScreen(
                navController = navController,
                viewModel = viewModel)
            }
            composable(Screen.SignUpScreen.route){
                SignUpScreen(
                    navController = navController,
                    viewModel = viewModel)
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
            composable(Screen.LoadingScreen.route){
                LaunchedEffect(viewModel){
                    viewModel.authResult.collect{result->
                        when(result){
                            is AuthResult.Authorized -> {
                                navController.navigate(Screen.MainScreen.route){
                                    popUpTo(Screen.MainScreen.route){
                                        inclusive = true
                                    }
                                }
                            }
                            is AuthResult.Unauthorized -> {
                                navController.navigate(
                                    if(isFirstTimeLaunch()){
                                        Screen.OnBoardingScreen.withArgs("1")
                                    } else {
                                        Screen.SignUpScreen.route
                                    }
                                ){
                                    popUpTo(Screen.LoadingScreen.route){
                                        inclusive = true
                                    }
                                }
                            }
                            is AuthResult.UnknownError -> {}
                        }
                    }
                }
                CircularProgressIndicator()
            }
        }
        navigation(startDestination = Screen.MainScreen.route, route = "main"){
            composable(Screen.MainScreen.route){
                MainScreen(
                    navigateToAuth = {navController.navigate(Screen.SignInScreen.route)}
                )
            }
        }


    }
}
fun isFirstTimeLaunch(): Boolean {
    val prefs = MyApp.appModule.prefs
    val isFirstTime = prefs.getBoolean("is_first_time", true)
    if (isFirstTime) {
        prefs.edit().putBoolean("is_first_time", false).apply()
    }
    return isFirstTime
}