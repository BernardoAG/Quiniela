package com.example.bernardoaltamirano.quiniela.base

import android.app.Application
import com.example.bernardoaltamirano.quiniela.BuildConfig
import timber.log.Timber

/**
 * Created by icaboalo on 03/05/18.
 */
class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}