package com.example.bernardoaltamirano.quiniela.base

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    fun provideApplicationContext(): Context = application
}