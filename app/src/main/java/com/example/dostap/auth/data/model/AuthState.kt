package com.example.dostap.auth.data.model

data class AuthState(
    val isLoading: Boolean = false,
    val signInUsername: String = "",
    val signInPassword: String = "",
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signUpUserLastName: String = "",
    val signUpEmail: String = ""
)
