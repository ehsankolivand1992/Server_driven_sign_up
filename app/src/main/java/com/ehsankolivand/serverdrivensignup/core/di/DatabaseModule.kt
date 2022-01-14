package com.ehsankolivand.serverdrivensignup.core.di

import android.app.Application
import androidx.room.Room
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDao
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(application: Application): FormDatabase =
        Room.databaseBuilder(application, FormDatabase::class.java, "form_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(database: FormDatabase): FormDao {
        return database.getFormDao()
    }
}

