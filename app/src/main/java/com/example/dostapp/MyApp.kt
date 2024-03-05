package com.example.dostapp

import android.app.Application
import com.example.dostapp.core.di.AppModule
import com.example.dostapp.core.di.AppModuleImpl

class MyApp: Application() {
    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}