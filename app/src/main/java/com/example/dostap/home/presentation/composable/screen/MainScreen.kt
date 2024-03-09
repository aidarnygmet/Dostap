package com.example.dostap.home.presentation.composable.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.dostap.R
import com.example.dostap.core.data.Screen

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean = false,
    val badgeCount: Int? = null
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigateToAuth: ()->Unit
){
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(title= Screen.HomeScreen.route,selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home),
        BottomNavigationItem(title= Screen.NotificationsScreen.route,selectedIcon = ImageVector.vectorResource(R.drawable.notification_filled), unselectedIcon = ImageVector.vectorResource(R.drawable.notification_outlined), hasNews = true),
        BottomNavigationItem(title="new",selectedIcon = Icons.Filled.Add, unselectedIcon = Icons.Outlined.Add),
        BottomNavigationItem(title= Screen.ChatsScreen.route,selectedIcon = ImageVector.vectorResource(
            R.drawable.forum_filled), unselectedIcon = ImageVector.vectorResource(R.drawable.forum_outlined), badgeCount = 7),
        BottomNavigationItem(title= Screen.ProfileScreen.route,selectedIcon = Icons.Filled.Person, unselectedIcon = Icons.Outlined.Person),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background

    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed{ index,item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                if(index != 2){
                                    selectedItemIndex = index
                                    navController.navigate(item.title){
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        restoreState = true
                                        launchSingleTop = true
                                    }
                                }

                                      },
                            icon = { 
                                BadgedBox(badge = {
                                    if(item.badgeCount != null){
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews){
                                        Badge {

                                        }
                                    }
                                }) {
                                    Icon(imageVector = if(selectedItemIndex == index){
                                        item.selectedIcon
                                    } else {item.unselectedIcon}, contentDescription = null)
                                }
                            })
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
            MainNavHost(
                modifier = Modifier,
                navController = navController,
                startDestination = Screen.HomeScreen.route,
                navigateToAuth = navigateToAuth
            )
            }

        }
    }





}