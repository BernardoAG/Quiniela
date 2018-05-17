package com.example.bernardoaltamirano.quiniela.base

import android.app.Application
import com.example.bernardoaltamirano.quiniela.BuildConfig
import com.example.bernardoaltamirano.quiniela.di.ActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by icaboalo on 01/02/18.
 *
 * Clase de sobreescritura de Application para poder iniciar Dagger y la injección de dependencias.
 */

class MyApplication : Application() {

    @Inject
    lateinit var activityInjector: ActivityInjector
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        /**
         * Aqui se comienza toda la injección para las pantallas.
         */
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        component.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
