package com.kotlinsampleproject

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlinsampleproject.data.AppData
import com.kotlinsampleproject.data.local.LocalRepo
import com.kotlinsampleproject.data.remote.Api
import com.kotlinsampleproject.data.remote.RemoteRepo
import com.kotlinsampleproject.data.remote.Urls
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by brain on 12/5/17.
 */
@Module
class AppModule(var app: App) {

    @Provides
    internal fun provideContext(): Context = app

    @Provides
    @Singleton
    internal fun gson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRemoteRepo(api: Api, gson: Gson): RemoteRepo {
        return RemoteRepo(api, gson)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("http://app.tracesell.com/api/")
//                .addConverterFactory(BaseResponseConverter())
                //                .addConverterFactory(ScalarsConverterFactory.create())//To convert primitive and boxed types
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideData(localRepo: LocalRepo, remoteRepo: RemoteRepo): AppData {
        return AppData(localRepo, remoteRepo)
    }
}