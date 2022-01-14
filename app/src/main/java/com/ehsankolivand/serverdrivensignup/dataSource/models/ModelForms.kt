package com.ehsankolivand.serverdrivensignup.dataSource.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ModelForms(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val currentPage: Int,
    val data: List<Data>,
    val totalPage: Int
)