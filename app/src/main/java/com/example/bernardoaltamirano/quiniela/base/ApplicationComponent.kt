package com.example.bernardoaltamirano.quiniela.base

import com.example.bernardoaltamirano.quiniela.data.login.LoginServiceModule
import com.example.bernardoaltamirano.quiniela.data.profile.ProfileServiceModule
import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaServiceModule
import com.example.bernardoaltamirano.quiniela.database.DatabaseModule
import com.example.bernardoaltamirano.quiniela.networking.ServiceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by icaboalo on 01/02/18.
 */

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ActivityBindingModule::class,
    ServiceModule::class,
    QuinielaServiceModule::class,
    LoginServiceModule::class,
    ProfileServiceModule::class,
    DatabaseModule::class
])
interface ApplicationComponent {
    fun inject(myApplication: MyApplication)
}
