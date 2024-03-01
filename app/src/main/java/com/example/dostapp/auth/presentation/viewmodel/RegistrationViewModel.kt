package com.example.dostapp.auth.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.domain.AuthUseCase
import kotlinx.coroutines.launch

class RegistrationViewModel(private val authUseCase: AuthUseCase) : ViewModel() {
    private val _email = mutableStateOf("")
    private val _password = mutableStateOf("")
    private val _name = mutableStateOf("")
    private val _registrationResult = mutableStateOf<AuthResult?>(null)

    val email: String get() = _email.value
    val password: String get() = _password.value
    val name: String get() = _name.value
    val registrationResult get() = _registrationResult.value

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setName(name: String) {
        _name.value = name
    }

    fun registerUser() {
        viewModelScope.launch {
            val result = authUseCase.registerUser(email, password, name)
            _registrationResult.value = result
        }
    }
}