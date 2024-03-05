package com.example.dostapp.core.di

import android.content.Context
import com.example.dostapp.auth.data.repository.AuthRepository
import com.example.dostapp.auth.domain.AuthRepositoryImpl
import com.example.dostapp.core.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule{
    val authApi: ApiService
    val authRepository: AuthRepository
}
class AppModuleImpl(private val appContext: Context): AppModule {
    override val authApi: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://rofl.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }

}