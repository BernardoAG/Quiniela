package com.example.bernardoaltamirano.quiniela.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by icaboalo on 01/02/18.
 */

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun provideApplicationContext(): Context = application

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Named("uid")
    fun provideUserId(sharedPreferences: SharedPreferences): String {
        return sharedPreferences.getString("uid", "123")
    }

}