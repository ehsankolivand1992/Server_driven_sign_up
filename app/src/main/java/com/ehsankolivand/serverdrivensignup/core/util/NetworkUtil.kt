package com.ehsankolivand.serverdrivensignup.core.util

import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.google.gson.Gson
import okhttp3.Response
import com.google.gson.JsonElement

import com.google.gson.JsonParser

import com.google.gson.JsonArray
import java.lang.Exception


//parse String Json to Model
fun Response.getFormData(): ModelForms
{
    val gson = Gson()
    return gson.fromJson(this.body?.string(),ModelForms::class.java)
}

