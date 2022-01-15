package com.ehsankolivand.serverdrivensignup.ui

import androidx.lifecycle.ViewModel
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDao
import com.ehsankolivand.serverdrivensignup.dataSource.repository.contract.FormRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainViewModel @Inject constructor(private val repository: FormRepository,
                                        private val formDao: FormDao)
    : ViewModel() {
    init {
        fetchData()
    }



    fun fetchData() = repository.fetchData()

}


