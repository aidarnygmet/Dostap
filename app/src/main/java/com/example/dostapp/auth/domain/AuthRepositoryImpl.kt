package com.example.dostapp.auth.domain

import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.model.UserCredentials
import com.example.dostapp.auth.data.model.UserInfo
import com.example.dostapp.auth.data.repository.AuthRepository
import com.example.dostapp.core.network.ApiService
import kotlinx.coroutines.delay

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {
    override suspend fun loginUser(credentials: UserCredentials): AuthResult {
        return try {
//            val response = apiService.loginUser(credentials)
//            if (response.isSuccessful) {
//                val userInfo = response.body() ?: throw Exception("User info is null")
//                AuthResult.Success(userInfo)
//            } else {
//                AuthResult.Error("Login failed: ${response.message()}")
//            }
            delay(5000)
            AuthResult.Success(UserInfo("228"))
        } catch (e: Exception) {
            AuthResult.Error("Login failed: ${e.message}")
        }
    }

    override suspend fun registerUser(credentials: UserCredentials, name: String): AuthResult {
        return try {
//            val response = apiService.registerUser(credentials, name)
//            if (response.isSuccessful) {
//                val userInfo = response.body() ?: throw Exception("User info is null")
//                AuthResult.Success(userInfo)
//            } else {
//                AuthResult.Error("Registration failed: ${response.message()}")
//            }
            delay(5000)
            AuthResult.Error("Registration failed: qotaqbas")
        } catch (e: Exception) {
            AuthResult.Error("Registration failed: ${e.message}")
        }
    }
}