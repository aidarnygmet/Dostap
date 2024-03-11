package com.example.dostap.auth.data.repository

import com.example.dostap.auth.data.model.SignInRequest
import com.example.dostap.auth.data.model.SignUpRequest
import com.example.dostap.auth.data.model.TokenResponse
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST("/signup")
    suspend fun signUp(@Body request: SignUpRequest)

    @POST("/login")
    suspend fun signIn(@Body request: SignInRequest): TokenResponse

    @GET("/")
    suspend fun helloworld(): ResponseBody

    @GET
    suspend fun authenticate(@Header("Authorization") token :String)
}