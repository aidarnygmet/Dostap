package com.example.dostap.auth.data.repository

import com.example.dostap.auth.data.model.AuthResult

interface AuthRepository {
    suspend fun signUp(email: String, password: String, username: String, lastname: String): AuthResult<Unit>
    suspend fun signIn(email: String, password: String): AuthResult<Unit>
    suspend fun helloworld(): String
    suspend fun authenticate(): AuthResult<Unit>
}