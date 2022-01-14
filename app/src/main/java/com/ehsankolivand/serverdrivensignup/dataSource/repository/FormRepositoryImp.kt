package com.ehsankolivand.serverdrivensignup.dataSource.repository

import com.ehsankolivand.serverdrivensignup.core.util.getFormData
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.repository.contract.FormRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import okhttp3.Call
import javax.inject.Inject

class FormRepositoryImp @Inject constructor(private val call: Call) : FormRepository {


    override fun fetchData() = Observable.create(ObservableOnSubscribe<ModelForms> {
        val response = call.execute()
        it.onNext(response.getFormData())
        it.onComplete()
    })


}