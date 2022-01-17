package com.ehsankolivand.serverdrivensignup.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ehsankolivand.serverdrivensignup.MyApp
import com.ehsankolivand.serverdrivensignup.core.base.BaseActivity
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel
import com.ehsankolivand.serverdrivensignup.databinding.ActivityMainBinding
import com.ehsankolivand.serverdrivensignup.ui.adapter.FormRecyclerViewAdapter
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    lateinit var formAdapter: FormRecyclerViewAdapter

    lateinit var formPage: ModelForms
    lateinit var newForm: RemoteFormModel
    lateinit var de:Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).component
            .inject(this)

        init()
        fetchData()

    }

    override fun setBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    @SuppressLint("ClickableViewAccessibility")
    fun fetchData() {

       de = mainViewModel.fetchData().subscribe {
            newForm = it
            val modelforms: ModelForms =
                Gson().fromJson(newForm.bodyMessage, ModelForms::class.java)
            this.formAdapter.datalist = modelforms
        }


    }

    fun init()
    {
        formAdapter = FormRecyclerViewAdapter(this)
        binding.rvForm.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.rvForm.setHasFixedSize(true)
        binding.rvForm.isNestedScrollingEnabled = true
        binding.rvForm.adapter = formAdapter

        binding.submit.setOnClickListener {

            val result = mainViewModel.submitValidation(formAdapter.dataHolder.data)

        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onPause() {
        super.onPause()
        newForm.bodyMessage = Gson().toJson(formAdapter.dataHolder)
        mainViewModel.updateDatabase(newForm)
        de.dispose()
    }
}