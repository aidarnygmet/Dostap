package com.example.dostapp.core.data
sealed class Screen(val route: String){
    object SignInScreen: Screen("sign_in")
    object SignUpScreen: Screen("sign_up")
    object MainScreen: Screen("main_screen")
    object OnBoardingScreen: Screen("on_boarding")
    object HomeScreen: Screen("home")
    object NotificationsScreen: Screen("notifications")
    object ChatsScreen: Screen("chats")
    object ProfileScreen: Screen("profile")
    object ExpandedEventScreen: Screen("expanded_event")
    fun withArgs(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}