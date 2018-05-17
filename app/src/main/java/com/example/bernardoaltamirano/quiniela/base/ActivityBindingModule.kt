package com.example.bernardoaltamirano.quiniela.base

import android.app.Activity
import com.example.bernardoaltamirano.quiniela.login.LoginActivity
import com.example.bernardoaltamirano.quiniela.login.LoginActivityComponent
import com.example.bernardoaltamirano.quiniela.main.MainActivity
import com.example.bernardoaltamirano.quiniela.main.MainActivityComponent
import com.example.bernardoaltamirano.quiniela.profile.ProfileActivity
import com.example.bernardoaltamirano.quiniela.profile.ProfileActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by icaboalo on 01/02/18.
 *
 * Clase para injectar las 3 distintas activities dentro de Dagger
 */

@Module(subcomponents = [
    MainActivityComponent::class,
    LoginActivityComponent::class,
    ProfileActivityComponent::class
])
abstract class ActivityBindingModule {

    /**
     * Se injecta individualmente cada una a un Map con la llave puesta como el valor de la clase.
     */

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
    abstract fun provideLoginActivityInjector(builder: LoginActivityComponent.Builder): AndroidInjector.Factory<out Activity>


    @Binds
    @IntoMap
    @ActivityKey(ProfileActivity::class)
    abstract fun provideProfileActivityInjector(builder: ProfileActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}