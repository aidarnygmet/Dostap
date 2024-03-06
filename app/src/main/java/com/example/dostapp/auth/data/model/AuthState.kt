package com.example.dostapp.auth.data.model

data class AuthState(
    val isLoading: Boolean = false,
    val signInUsername: String = "",
    val signInPassword: String = "",
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signUpEmail: String = ""
)
