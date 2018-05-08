package com.example.bernardoaltamirano.quiniela.base

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private var application: MyApplication) {

    @Provides
    fun provideApplicationModule(): Context = application
}