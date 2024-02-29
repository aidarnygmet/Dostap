package com.example.dostapp.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
    navigateTo: (route: String) -> Unit
){
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier){
        composable(Screen.HomeScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            HomeScreen()
        }
        composable(Screen.NotificationsScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            NotificationScreen()
        }
        composable(Screen.ChatsScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            ChatsScreen()
        }
        composable(Screen.ProfileScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            ProfileScreen()
        }
    }
}