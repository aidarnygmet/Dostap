package com.example.dostap.core.di

import android.content.Context
import android.content.SharedPreferences
import com.example.dostap.auth.data.repository.AuthApi
import com.example.dostap.auth.data.repository.AuthRepository
import com.example.dostap.auth.domain.AuthRepositoryImpl
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule{
    val authApi: AuthApi
    val authRepository: AuthRepository
    val prefs: SharedPreferences
    val locationClient: FusedLocationProviderClient
    val loggingInterceptor: HttpLoggingInterceptor
    val okHttpClient: OkHttpClient
}
class AppModuleImpl(private val appContext: Context): AppModule {
    override val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    override val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    override val authApi: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://92.38.48.85:80")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi = authApi, prefs = prefs)
    }
    override val prefs: SharedPreferences by lazy {
        appContext.getSharedPreferences("dostap", Context.MODE_PRIVATE)
    }
    override val locationClient: FusedLocationProviderClient by lazy{
        LocationServices.getFusedLocationProviderClient(appContext)
    }



}