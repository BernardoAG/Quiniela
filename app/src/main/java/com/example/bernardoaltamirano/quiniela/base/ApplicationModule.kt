package com.example.bernardoaltamirano.quiniela.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by icaboalo on 01/02/18.
 */

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun provideApplicationContext(): Context = application

}