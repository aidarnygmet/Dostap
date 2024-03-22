package com.example.dostap.home.presentation.composable.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.dostap.R
import com.example.dostap.core.data.Screen

data class BottomNavigationItem(
    val title: String,
    val text: String,
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
    val context = LocalContext.current
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            title= Screen.HomeScreen.route,
            text=context.getString(R.string.home_screen),
            selectedIcon = ImageVector.vectorResource(R.drawable.home_bottom_bar),
            unselectedIcon = ImageVector.vectorResource(R.drawable.home_bottom_bar)),
        BottomNavigationItem(
            title= Screen.NotificationsScreen.route,
            text=context.getString(R.string.connections),
            selectedIcon = ImageVector.vectorResource(R.drawable.chat_bottom_bar),
            unselectedIcon = ImageVector.vectorResource(R.drawable.chat_bottom_bar)),
        BottomNavigationItem(
            title="new",
            text=context.getString(R.string.create),
            selectedIcon = ImageVector.vectorResource(R.drawable.new_event_bottom_bar),
            unselectedIcon = ImageVector.vectorResource(R.drawable.new_event_bottom_bar)),
        BottomNavigationItem(
            title= Screen.ChatsScreen.route,
            text=context.getString(R.string.chats),
            selectedIcon = ImageVector.vectorResource(R.drawable.chat_bottom_bar),
            unselectedIcon = ImageVector.vectorResource(R.drawable.chat_bottom_bar)),
        BottomNavigationItem(
            title= Screen.ProfileScreen.route,
            text=context.getString(R.string.profile),
            selectedIcon = ImageVector.vectorResource(R.drawable.profile_bottom_bar),
            unselectedIcon = ImageVector.vectorResource(R.drawable.profile_bottom_bar)),
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background

    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = Color.White
                ) {
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
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Icon(imageVector = if(selectedItemIndex == index){
                                            item.selectedIcon
                                        } else {item.unselectedIcon}, contentDescription = null)
                                        Spacer(modifier = Modifier.size(4.dp))
                                        Text(text = item.text, style = MaterialTheme.typography.labelLarge)
                                    }

                                }
                            },
                            colors = NavigationBarItemColors(
                                selectedIconColor = Color(0xFF1A8EEA),
                                selectedTextColor = Color(0xFF1A8EEA),
                                selectedIndicatorColor = Color.Transparent,
                                unselectedIconColor = Color.Black,
                                unselectedTextColor = Color.Black,
                                disabledIconColor = Color.Gray,
                                disabledTextColor = Color.Gray
                            )
                        )
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