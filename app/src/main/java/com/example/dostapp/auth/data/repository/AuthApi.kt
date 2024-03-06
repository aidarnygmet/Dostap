package com.example.dostapp.auth.data.repository

import com.example.dostapp.auth.data.model.AuthRequest
import com.example.dostapp.auth.data.model.SignUpRequest
import com.example.dostapp.auth.data.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST("signup")
    suspend fun signUp(@Body request: SignUpRequest)

    @POST("signin")
    suspend fun signIn(@Body request: AuthRequest): TokenResponse

    @GET
    suspend fun authenticate(@Header("Authorization") token :String)
}