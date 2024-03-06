package com.example.dostapp.auth.data.repository

import com.example.dostapp.auth.data.model.AuthResult

interface AuthRepository {
    suspend fun signUp(email: String, password: String, username: String): AuthResult<Unit>
    suspend fun signIn(email: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}