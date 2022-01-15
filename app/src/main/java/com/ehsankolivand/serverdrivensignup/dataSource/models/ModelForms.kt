package com.ehsankolivand.serverdrivensignup.dataSource.models

import androidx.room.Entity
import androidx.room.PrimaryKey


data class ModelForms(
    val currentPage: Int=0,
    val data: MutableList<Data> = mutableListOf(),
    val totalPage: Int=0
)