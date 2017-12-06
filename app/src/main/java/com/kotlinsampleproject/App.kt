package com.kotlinsampleproject

import android.app.Application

/**
 * Created by brain on 12/5/17.
 */
class App : Application(){

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

//        component = Dagger
    }
}