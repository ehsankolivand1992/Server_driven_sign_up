package com.ehsankolivand.serverdrivensignup.dataSource.pagingtest

import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel
import com.google.gson.Gson

class FormMapper {
    companion object {


        fun transform(modelForms: ModelForms) =
            RemoteFormModel(
                0,
                modelForms.totalPage,
                modelForms.currentPage,
                Gson().toJson(modelForms)
            )
    }

}