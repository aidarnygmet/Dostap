package com.example.dostapp.home.presentation.composable.screen

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dostapp.R
import com.example.dostapp.core.data.Screen
import com.example.dostapp.home.data.model.EventCard

@Composable
fun MainNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String
){
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier){
        composable(
            Screen.HomeScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            HomeScreen(onClick = {
                navController.navigate(Screen.ExpandedEventScreen.route)
            })
        }
        composable(
            Screen.NotificationsScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            NotificationScreen()
        }
        composable(
            Screen.ChatsScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            ChatsScreen()
        }
        composable(
            Screen.ProfileScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            ProfileScreen()
        }
        composable(Screen.ExpandedEventScreen.route){
            val eventCard = EventCard(
                name = "Футбол на Ботаническом", address = "Ботанический Парк, Астана", time ="Суббота, 24.10 в 17:00",
                rating = 4.5F, category = "Футбол",
                pic = R.drawable.ronaldo_big)
            ExpandedEventScreen(eventCard = eventCard, navController = navController)
        }
    }
}