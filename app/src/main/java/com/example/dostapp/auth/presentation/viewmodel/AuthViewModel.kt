package com.example.dostapp.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.model.UserCredentials
import com.example.dostapp.auth.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository): ViewModel() {
    private val _user = MutableStateFlow<AuthResult?>(null)
    val user : StateFlow<AuthResult?> get() = _user
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading
    fun nullifyUser(){
        _user.value = null
    }
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _user.value = authRepository.loginUser(UserCredentials(email, password))
            _isLoading.value = false
        }
    }
    fun signUp(email: String, password: String, name: String){
        viewModelScope.launch {
            _isLoading.value = true
            _user.value = authRepository.registerUser(UserCredentials(email, password), name)
            _isLoading.value = false
        }
    }
}