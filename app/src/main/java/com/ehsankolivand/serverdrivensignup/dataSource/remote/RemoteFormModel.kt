package com.ehsankolivand.serverdrivensignup.dataSource.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteFormModel(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val pageCount:Int,
    val pageNumber:Int,
    var bodyMessage:String
)