package com.example.dostap

import android.app.Application
import com.example.dostap.core.di.AppModule
import com.example.dostap.core.di.AppModuleImpl

class MyApp: Application() {
    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}