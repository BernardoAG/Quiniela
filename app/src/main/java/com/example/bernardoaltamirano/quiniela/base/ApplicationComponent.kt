package com.example.bernardoaltamirano.quiniela.base

import com.example.bernardoaltamirano.quiniela.data.login.LoginServiceModule
import com.example.bernardoaltamirano.quiniela.data.profile.ProfileServiceModule
import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaServiceModule
import com.example.bernardoaltamirano.quiniela.networking.ServiceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by icaboalo on 01/02/18.
 *
 * Esta clase funciona para ser llamada únicamente desde el Application para injectar todas las
 * dependencias que se dieron en los disstintos modulos.
 */

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ActivityBindingModule::class,
    ServiceModule::class,
    QuinielaServiceModule::class,
    LoginServiceModule::class,
    ProfileServiceModule::class
])
interface ApplicationComponent {
    fun inject(myApplication: MyApplication)
}
