package com.example.dostapp.auth.data.model

sealed class AuthResult {
    data class Success(val userInfo: UserInfo) : AuthResult()
    data class Error(val message: String) : AuthResult()
}