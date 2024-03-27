package com.example.dostap.auth.data.repository

import com.example.dostap.auth.data.model.LoginResult
import com.example.dostap.auth.data.model.SignUpResult

interface AuthRepository {
    suspend fun signUp(email: String, password: String, username: String, lastname: String): SignUpResult<Unit>
    suspend fun signIn(email: String, password: String): LoginResult<Unit>
    suspend fun deleteAccount(token: String)
    suspend fun helloworld(): String
    suspend fun authenticate(): LoginResult<Unit>
}