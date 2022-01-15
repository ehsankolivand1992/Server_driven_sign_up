package com.ehsankolivand.serverdrivensignup.dataSource.repository.contract

import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.models.RemoteFormModel
import io.reactivex.rxjava3.core.Observable

interface FormRepository {
    fun fetchData(): Observable<RemoteFormModel>

}