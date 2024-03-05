package com.example.dostapp.core.network

import com.example.dostapp.auth.data.model.UserCredentials
import com.example.dostapp.auth.data.model.UserInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    suspend fun loginUser(@Body credentials: UserCredentials): Response<UserInfo>

    @POST("register")
    suspend fun registerUser(@Body credentials: UserCredentials, @Query("name") name: String): Response<UserInfo>
}