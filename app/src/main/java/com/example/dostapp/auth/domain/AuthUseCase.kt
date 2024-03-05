package com.example.dostapp.auth.domain

import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.model.UserCredentials

class AuthUseCase(private val authRepository: AuthRepositoryImpl) {
    suspend fun loginUser(email: String, password: String): AuthResult {
        return try {
            val result = authRepository.loginUser(UserCredentials(email, password))
            when (result) {
                is AuthResult.Success -> result
                is AuthResult.Error -> result
            }
        } catch (e: Exception) {
            AuthResult.Error("Login failed: ${e.message}")
        }
    }

    suspend fun registerUser(email: String, password: String, name: String): AuthResult {
        return try {
            val result = authRepository.registerUser(UserCredentials(email, password), name)
            when (result) {
                is AuthResult.Success -> result
                is AuthResult.Error -> result
            }
        } catch (e: Exception) {
            AuthResult.Error("Registration failed: ${e.message}")
        }
    }
}
