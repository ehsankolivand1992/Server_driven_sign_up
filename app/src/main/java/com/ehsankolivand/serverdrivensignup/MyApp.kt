package com.ehsankolivand.serverdrivensignup

import android.app.Application
import com.ehsankolivand.serverdrivensignup.core.di.AppComponent
import com.ehsankolivand.serverdrivensignup.core.di.DaggerAppComponent
import com.ehsankolivand.serverdrivensignup.core.di.NetworkModule

class MyApp: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}