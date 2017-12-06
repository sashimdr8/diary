package com.kotlinsampleproject

import com.kotlinsampleproject.data.remote.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by brain on 12/5/17.
 */
@Module(includes = arrayOf(AppModule::class))
class DataModule {

    @Provides
    @Singleton
    internal fun okHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
                .build()
    }

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create<Api>(Api::class.java!!)
    }
}