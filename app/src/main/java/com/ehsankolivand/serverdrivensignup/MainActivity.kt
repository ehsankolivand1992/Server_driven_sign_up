package com.ehsankolivand.serverdrivensignup

import android.os.Bundle
import com.ehsankolivand.serverdrivensignup.core.base.BaseActivity
import com.ehsankolivand.serverdrivensignup.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).component
            .inject(this)
    }

    override fun setBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}