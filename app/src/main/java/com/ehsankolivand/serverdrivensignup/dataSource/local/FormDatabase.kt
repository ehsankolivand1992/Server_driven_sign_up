package com.ehsankolivand.serverdrivensignup.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms


@Database(entities = [
    ModelForms::class
],
    version = 1,
    exportSchema = true)
@TypeConverters(DataFormTypeConvertor::class)
abstract class FormDatabase: RoomDatabase() {
    abstract fun getFormDao():FormDao
}
