package com.example.bernardoaltamirano.quiniela.base

import android.app.Activity
import com.example.bernardoaltamirano.quiniela.login.LoginActivity
import com.example.bernardoaltamirano.quiniela.login.LoginActivityComponent
import com.example.bernardoaltamirano.quiniela.main.MainActivity
import com.example.bernardoaltamirano.quiniela.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by icaboalo on 01/02/18.
 */

@Module(subcomponents = [
    MainActivityComponent::class,
    LoginActivityComponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
    internal abstract fun provideLoginActivityInjector(builder: LoginActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}