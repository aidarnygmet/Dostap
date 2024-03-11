package com.example.dostap

import android.app.Application
import com.example.dostap.core.di.AppModule
import com.example.dostap.core.di.AppModuleImpl
import com.yandex.mapkit.MapKitFactory

class MyApp: Application() {
    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("305d5e0c-9cfe-45dd-86c9-f4c9616c2b97")
        appModule = AppModuleImpl(this)
    }
}