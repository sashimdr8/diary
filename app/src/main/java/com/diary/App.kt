package com.diary

import android.app.Application
import android.content.Context

/**
 * Created by brain on 12/5/17.
 */
class App : Application(){

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.component = DaggerComponentInitializer.init(this)
    }

    fun component(context: Context): AppComponent {
        return (context.applicationContext as App).component
    }

    private object DaggerComponentInitializer {

        internal fun init(context: Context): AppComponent {
            return DaggerAppComponent.builder()
                    .appModule(AppModule(context.applicationContext))
                    .build()

        }
    }
}