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
 *
 * Clase que injecta ciertos valores a cada clase que se decida injectar a las dependencias
 *
 * Tiene la anotación está pertenece a la clase Application por lo que se creará instancia de los
 * valores sólo una vez.
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

    @Provides
    @Named("u_name")
    fun provideUserName(sharedPreferences: SharedPreferences): String {
        return sharedPreferences.getString("u_name", "Usuario de prueba")
    }

}