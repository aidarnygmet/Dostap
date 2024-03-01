package com.example.dostapp.auth.data.repository

import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.model.UserCredentials
import com.example.dostapp.auth.network.ApiService

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {
    override suspend fun loginUser(credentials: UserCredentials): AuthResult {
        return try {
            // Make API call to login user using credentials
            val response = apiService.loginUser(credentials)
            if (response.isSuccessful) {
                val userInfo = response.body() ?: throw Exception("User info is null")
                AuthResult.Success(userInfo)
            } else {
                AuthResult.Error("Login failed: ${response.message()}")
            }
        } catch (e: Exception) {
            AuthResult.Error("Login failed: ${e.message}")
        }
    }

    override suspend fun registerUser(credentials: UserCredentials, name: String): AuthResult {
        return try {
            // Make API call to register user using credentials and name
            val response = apiService.registerUser(credentials, name)
            if (response.isSuccessful) {
                val userInfo = response.body() ?: throw Exception("User info is null")
                AuthResult.Success(userInfo)
            } else {
                AuthResult.Error("Registration failed: ${response.message()}")
            }
        } catch (e: Exception) {
            AuthResult.Error("Registration failed: ${e.message}")
        }
    }
}