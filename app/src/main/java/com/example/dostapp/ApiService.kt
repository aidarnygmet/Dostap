package com.example.dostapp

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    fun ping(): Call<JsonElement>

}