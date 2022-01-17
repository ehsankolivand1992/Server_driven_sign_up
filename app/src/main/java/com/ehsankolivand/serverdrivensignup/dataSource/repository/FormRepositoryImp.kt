package com.ehsankolivand.serverdrivensignup.dataSource.repository

import android.util.Log
import com.ehsankolivand.serverdrivensignup.dataSource.local.FormDao
import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel
import com.ehsankolivand.serverdrivensignup.dataSource.remote.NetworkAdapter
import com.ehsankolivand.serverdrivensignup.dataSource.repository.contract.FormRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FormRepositoryImp @Inject constructor(private val networkAdapter: NetworkAdapter,private val formDao: FormDao)
    : FormRepository {
    val Tag = "Repository"


    override fun fetchData(pageNumber: Int) = catchData(pageNumber)


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

    private fun catchData(pageNumber:Int)= Observable.create<RemoteFormModel> {
        var model = formDao.getFormData()
        if (model ==null)
        {
            it.onNext(networkAdapter.provideOkhttpRequest(pageNumber.toString()))

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