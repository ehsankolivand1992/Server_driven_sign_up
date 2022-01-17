package com.ehsankolivand.serverdrivensignup.dataSource.remote

import com.ehsankolivand.serverdrivensignup.core.util.getFormData
import com.ehsankolivand.serverdrivensignup.dataSource.pagingtest.FormMapper
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class NetworkAdapter @Inject constructor(private var http: OkHttpClient) {


    fun provideOkhttpRequest(url: String): RemoteFormModel {
        var request = Request.Builder()
            .url(Companion.BASE_URL + url)
            .build()
        val form = http.newCall(request).execute().getFormData()
        return FormMapper.transform(form)

    }


    companion object {
        const val BASE_URL = "https://ehsanet.ir/api/assignment/form?page="
    }

}