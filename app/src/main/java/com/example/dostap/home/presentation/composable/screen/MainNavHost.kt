package com.example.dostap.home.presentation.composable.screen

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dostap.R
import com.example.dostap.auth.data.model.Category
import com.example.dostap.core.data.Screen
import com.example.dostap.home.data.model.EventCard
import com.example.dostap.home.data.model.ProfileData

@Composable
fun MainNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
    navigateToAuth: ()->Unit
){
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier){
        composable(
            Screen.HomeScreen.route,
            enterTransition = {
                slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            HomeScreen(onClick = {
                navController.navigate(Screen.ExpandedEventScreen.route)
            })
        }
        composable(
            Screen.NotificationsScreen.route,
            enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)},
            exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)}){
            YandexMap()
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
            val profileData = ProfileData(
                "qotaqbas",
                R.drawable.ronaldo_big,
                228,
                "Qotaq",
                11,
                "Ashana",
                listOf("dalbeob", "mal"),
                listOf(Category.Art, Category.Movies)
            )
            ProfileScreen(profileData = profileData, navController = navController)
        }
        composable(Screen.ExpandedEventScreen.route){
            val eventCard = EventCard(
                name = "Футбол на Ботаническом", address = "Ботанический Парк, Астана", time ="Суббота, 24.10 в 17:00",
                rating = 4.5F, category = "Футбол",
                pic = R.drawable.ronaldo_big)
            ExpandedEventScreen(eventCard = eventCard, navController = navController)
        }
        composable(Screen.SettingsScreen.route){
            SettingsScreen(
                navigateToAuth = navigateToAuth
            )
        }
    }
}