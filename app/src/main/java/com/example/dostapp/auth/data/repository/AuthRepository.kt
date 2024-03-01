package com.example.dostapp.auth.data.repository

import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.model.UserCredentials

interface AuthRepository {
    suspend fun loginUser(credentials: UserCredentials): AuthResult
    suspend fun registerUser(credentials: UserCredentials, name: String): AuthResult
}