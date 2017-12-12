package com.diary

import android.app.Application
import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by brain on 12/5/17.
 */
class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.component = DaggerComponentInitializer.init(this)

        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                //                .migration(new MyMigration()) // Migration to run
                .build()
        Realm.setDefaultConfiguration(config)
    }

    companion object {
        fun component(context: Context): AppComponent {
            return (context.applicationContext as App).component
        }
    }


    private object DaggerComponentInitializer {

        internal fun init(context: Context): AppComponent {
            return DaggerAppComponent.builder()
                    .appModule(AppModule(context.applicationContext))
                    .build()

        }
    }
}