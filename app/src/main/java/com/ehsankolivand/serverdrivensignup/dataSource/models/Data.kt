package com.ehsankolivand.serverdrivensignup.dataSource.models

data class Data(
    val isRequired: Boolean,
    val name: String,
    val type: String,
    val values: Values,
    var answer:String
)