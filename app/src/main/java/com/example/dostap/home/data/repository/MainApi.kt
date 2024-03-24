package com.example.dostap.home.data.repository

import retrofit2.http.PUT

interface MainApi {
    @PUT("/deleteAccount")
    fun deleteAccount()
}