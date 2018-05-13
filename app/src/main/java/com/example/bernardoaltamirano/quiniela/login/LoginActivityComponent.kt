package com.example.bernardoaltamirano.quiniela.login

import com.example.bernardoaltamirano.quiniela.di.ActivityScope
import com.example.bernardoaltamirano.quiniela.ui.NavigationModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [
    LoginScreenBindingModule::class,
    NavigationModule::class
])
interface LoginActivityComponent: AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<LoginActivity>() {

    }
}