package com.ehsankolivand.serverdrivensignup.dataSource.repository.contract

import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import io.reactivex.rxjava3.core.Observable

interface FormRepository {
    fun fetchData(): Observable<ModelForms>

}