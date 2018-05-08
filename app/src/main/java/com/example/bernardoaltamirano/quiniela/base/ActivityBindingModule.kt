package com.example.bernardoaltamirano.quiniela.base

import android.app.Activity
import com.example.bernardoaltamirano.quiniela.MainActivity
import com.example.bernardoaltamirano.quiniela.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    MainActivityComponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}