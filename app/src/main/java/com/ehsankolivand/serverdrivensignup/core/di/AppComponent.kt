package com.ehsankolivand.serverdrivensignup.core.di

import com.ehsankolivand.serverdrivensignup.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,DatabaseModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}