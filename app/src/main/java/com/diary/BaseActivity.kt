package com.diary.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.diary.App

/**
 * Created by brain on 12/5/17.
 */
open class BaseActivity : AppCompatActivity() {


    fun static() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        App.component(this).inject(this)
    }


    fun consumeBackPress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onTokenExpired() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}