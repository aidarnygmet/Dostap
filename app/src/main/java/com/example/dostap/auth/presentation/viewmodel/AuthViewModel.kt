package com.example.dostap.auth.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dostap.auth.data.model.AuthState
import com.example.dostap.auth.data.model.AuthUiEvent
import com.example.dostap.auth.data.model.LoginResult
import com.example.dostap.auth.data.model.SignUpResult
import com.example.dostap.auth.data.repository.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository): ViewModel() {

    var state by mutableStateOf(AuthState())
    private val loginResultChannel = Channel<LoginResult<Unit>>()
    val loginResult = loginResultChannel.receiveAsFlow()
    private val signUpResultChannel = Channel<SignUpResult<Unit>>()
    val signUpResult = signUpResultChannel.receiveAsFlow()
    init {
        authenticate()
    }

    fun onEvent(event: AuthUiEvent){
        when(event){
            is AuthUiEvent.SignInPasswordChanged -> {
                state = state.copy(signInPassword = event.value)
            }
            is AuthUiEvent.SignInUsernameChanged -> {
                state = state.copy(signInUsername = event.value)
            }
            is AuthUiEvent.SignIn -> {
                signIn()
            }
            is AuthUiEvent.SignUpEmailChanged -> {
                state = state.copy(signUpEmail = event.value)
            }
            is AuthUiEvent.SignUpPasswordChanged -> {
                state = state.copy(signUpPassword = event.value)
            }
            is AuthUiEvent.SignUpUsernameChanged -> {
                state = state.copy(signUpUsername = event.value)
            }
            is AuthUiEvent.SignUp -> {
                signUp()
            }
            is AuthUiEvent.GoogleSignIn -> {
                helloworld()
            }

            is AuthUiEvent.SignUpLastNameChanged -> {
                state = state.copy(signUpUserLastName = event.value)
            }
        }
    }
    private fun signUp(){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = authRepository.signUp(
                email = state.signUpEmail,
                username = state.signUpUsername,
                password = state.signUpPassword,
                lastname = state.signUpUserLastName
            )
            signUpResultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }
    private fun signIn(){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = authRepository.signIn(
                email = state.signInUsername,
                password = state.signInPassword
            )
            loginResultChannel.send(result)
            state = state.copy(isLoading = false)

        }
    }
    private fun helloworld(){
        viewModelScope.launch {
            val result = authRepository.helloworld()
            Log.d("test", result)
        }
    }
    private fun authenticate(){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = authRepository.authenticate(
            )
            loginResultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }
}