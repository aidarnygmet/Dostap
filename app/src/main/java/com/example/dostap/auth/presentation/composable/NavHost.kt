package com.example.dostap.auth.presentation.composable

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.dostap.MyApp
import com.example.dostap.auth.data.model.AuthState
import com.example.dostap.auth.data.model.AuthUiEvent
import com.example.dostap.auth.data.model.LoginResult
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
                    viewModel = viewModel,
                    navigateToSignUp = {
                        navController.navigate(Screen.SignUpScreen.route)
                    },
                    authorized = {
                        navController.navigate(Screen.MainScreen.route){
                            popUpTo("auth"){
                                inclusive = true
                            }
                        }
                        viewModel.state = AuthState()
                    })
            }
            composable(Screen.SignUpScreen.route){
                SignUpScreen(
                    navController = navController,
                    viewModel = viewModel,
                    navigateToSignIn = {
                        navController.navigate(Screen.SignInScreen.route)
                    },
                    verificationSent = {
                        navController.navigate(Screen.EmailVerification.route)
                    })
            }
            composable(Screen.OnBoardingScreen.route){
                OnBoarding(){
                    navController.navigate(Screen.SignUpScreen.route){
                        popUpTo(Screen.OnBoardingScreen.route){
                            inclusive = true
                        }
                    }
                }
            }
            composable(Screen.LoadingScreen.route){
                LaunchedEffect(viewModel){
                    viewModel.loginResult.collect{result->
                        when(result){
                            is LoginResult.Authorized -> {
                                navController.navigate(Screen.MainScreen.route){
                                    popUpTo("auth"){
                                        inclusive = true
                                    }
                                }
                            }
                            is LoginResult.Unauthorized -> {
                                navController.navigate(
                                    if(isFirstTimeLaunch()){
                                        Screen.OnBoardingScreen.route
                                    } else {
                                        Screen.SignUpScreen.route
                                    }
                                ){
                                    popUpTo(Screen.LoadingScreen.route){
                                        inclusive = true
                                    }
                                }
                            }

                            else -> {}
                        }
                    }
                }
                CircularProgressIndicator()
            }
            composable(Screen.EmailVerification.route){
                LaunchedEffect(viewModel){
                    viewModel.loginResult.collect{result->
                        when(result){
                            is LoginResult.Authorized -> {
                                navController.navigate(Screen.MainScreen.route){
                                    popUpTo("auth"){
                                        inclusive = true
                                    }
                                }
                                viewModel.state = AuthState()
                            }
                            is LoginResult.Unauthorized -> {
                                navController.navigate(
                                    Screen.SignUpScreen.route
                                ){
                                    popUpTo("auth"){
                                        inclusive = true
                                    }
                                }
                            }
                            else -> {}
                        }
                    }
                }
                Surface {
                    Button(onClick = {
                        viewModel.state = viewModel.state.copy(signInPassword = viewModel.state.signUpPassword,
                            signInUsername = viewModel.state.signUpEmail)
                        viewModel.onEvent(AuthUiEvent.SignIn)
                    }) {
                        Text(text = "I verified my email")
                    }
                }
            }
        }
        navigation(startDestination = Screen.MainScreen.route, route = "main"){
            composable(Screen.MainScreen.route){
                MainScreen(
                    navigateToAuth = {
                        navController.navigate(Screen.SignInScreen.route){
                            popUpTo(Screen.MainScreen.route){
                                inclusive = true
                            }
                    } }
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