package com.ehsankolivand.serverdrivensignup.ui

import androidx.lifecycle.ViewModel
import com.ehsankolivand.serverdrivensignup.core.util.Datavalidation
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDao
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel
import com.ehsankolivand.serverdrivensignup.dataSource.repository.FormRepositoryImp
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainViewModel @Inject constructor(private val repository: FormRepositoryImp,
                                        private val formDao: FormDao)
    :ViewModel() {
    init {
        fetchData()
    }


    fun submitValidation(data: List<Data>):Boolean
    {
        return Datavalidation(data)
    }


    fun fetchData() =
        repository.fetchData(0)


    fun updateDatabase(newForm: RemoteFormModel)
    {
        repository.update(newForm)
    }
}
