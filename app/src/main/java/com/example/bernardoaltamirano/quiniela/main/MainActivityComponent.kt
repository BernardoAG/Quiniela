package com.example.bernardoaltamirano.quiniela.main

import com.example.bernardoaltamirano.quiniela.di.ActivityScope
import com.example.bernardoaltamirano.quiniela.ui.NavigationModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Activity encargada de proveer un builder para generar la injección para la activity especifica
 */
@ActivityScope
@Subcomponent(modules = [
    MainScreenBindingModule::class,
    NavigationModule::class
])
interface MainActivityComponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>() {

    }
}