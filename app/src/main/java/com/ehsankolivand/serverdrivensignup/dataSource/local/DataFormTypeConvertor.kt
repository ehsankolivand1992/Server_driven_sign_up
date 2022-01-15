package com.ehsankolivand.serverdrivensignup.dataSource.local

import androidx.room.TypeConverter
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.google.gson.Gson

class DataFormTypeConvertor {
    @TypeConverter
    fun listToJson(value: List<Data>)= Gson().toJson(value)

    @TypeConverter
    fun JsonToList(value:String)
    = Gson().fromJson(value,ArrayList<Data>()::class.java)
}