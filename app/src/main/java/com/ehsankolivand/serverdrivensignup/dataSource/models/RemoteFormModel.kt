package com.ehsankolivand.serverdrivensignup.dataSource.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteFormModel(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val bodyMessage:String
)