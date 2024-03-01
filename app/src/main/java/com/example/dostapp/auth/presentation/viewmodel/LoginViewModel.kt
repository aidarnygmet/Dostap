package com.example.dostapp.auth.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.domain.AuthUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val authUseCase: AuthUseCase): ViewModel() {
    private val _email = mutableStateOf("")
    private val _password = mutableStateOf("")
    private val _loginResult = mutableStateOf<AuthResult?>(null)

    val email: String get() = _email.value
    val password: String get() = _password.value
    val loginResult: AuthResult? get() = _loginResult.value

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun loginUser() {
        viewModelScope.launch {
            val result = authUseCase.loginUser(email, password)
            _loginResult.value = result
            // Handle the result, such as navigating to another screen
        }
    }
}