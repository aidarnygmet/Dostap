package com.example.dostap.auth.data.model

data class SignUpRequest(
    val username: String,
    val password: String,
    val email: String
)