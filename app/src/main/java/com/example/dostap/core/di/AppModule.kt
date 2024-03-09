package com.example.dostap.core.di

import android.content.Context
import android.content.SharedPreferences
import com.example.dostap.auth.data.repository.AuthApi
import com.example.dostap.auth.data.repository.AuthRepository
import com.example.dostap.auth.domain.AuthRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule{
    val authApi: AuthApi
    val authRepository: AuthRepository
    val prefs: SharedPreferences
}
class AppModuleImpl(private val appContext: Context): AppModule {
    override val authApi: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://92.38.48.85:80")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi = authApi, prefs = prefs)
    }
    override val prefs: SharedPreferences by lazy {
        appContext.getSharedPreferences("dostap", Context.MODE_PRIVATE)
    }

}