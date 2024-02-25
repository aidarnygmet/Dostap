package com.example.dostapp.screens
sealed class Screen(val route: String){
    object SignInScreen: Screen("sign_in")
    object SignUpScreen: Screen("sign_up")
    fun withArgs(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}