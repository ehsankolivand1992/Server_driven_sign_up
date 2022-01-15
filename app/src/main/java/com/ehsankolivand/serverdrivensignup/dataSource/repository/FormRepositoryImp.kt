package com.ehsankolivand.serverdrivensignup.dataSource.repository

import android.util.Log
import com.ehsankolivand.serverdrivensignup.core.util.getFormData
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDao
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.models.RemoteFormModel
import com.ehsankolivand.serverdrivensignup.dataSource.repository.contract.FormRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.Call
import javax.inject.Inject

class FormRepositoryImp @Inject constructor(private val call: Call,private val formDao: FormDao)
    : FormRepository {
    val Tag = "Repository"


    override fun fetchData() = catchData()


    override fun update(newForm: RemoteFormModel)
    {
        Observable.create<Unit> {
            formDao.updateFormData(newForm)
        }.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.i(Tag,"Database Updated")
            }
    }


    //The ViewModel does not need to know where the data is coming from.
    private fun catchData()= Observable.create<RemoteFormModel> {
        var model = formDao.getFormData()
        if (model ==null)
        {
            it.onNext(call.execute().body?.let { it1 -> RemoteFormModel(0, it1.string()) }!!)

        }else{
            it.onNext(model)
        }
    }.subscribeOn(Schedulers.io())
        .map {
            if (it.id!= null && it.id> 0)
            {
                return@map it
            }else {
                formDao.insertFormData(it)
                return@map formDao.getFormData()
            }
        }.map {
            formDao.insertFormData(it)
            return@map formDao.getFormData()
        }.observeOn(AndroidSchedulers.mainThread())



}