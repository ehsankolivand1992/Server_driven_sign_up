package com.ehsankolivand.serverdrivensignup.dataSource.models

data class ModelForms(
    val currentPage: Int,
    val `data`: List<Data>,
    val totalPage: Int
)