package com.ehsankolivand.serverdrivensignup.dataSource.repository.contract

import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel
import io.reactivex.rxjava3.core.Observable

interface FormRepository {

    fun fetchData(pageNumber:Int): Observable<RemoteFormModel>

    fun update(newForm: RemoteFormModel)

}