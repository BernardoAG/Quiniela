package com.example.bernardoaltamirano.quiniela.networking

import android.util.Log
import com.example.bernardoaltamirano.quiniela.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by icaboalo on 07/02/18.
 */

@Module
object NetworkingModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(): Call.Factory {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor { message -> Log.d("NetworkInfo", message) }
                        .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @JvmStatic
    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String {
        return "https://us-central1-quinielas-dd7a2.cloudfunctions.net/"
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor { message -> Log.d("NetworkInfo", message) }
                        .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
        return builder.build()
    }
}