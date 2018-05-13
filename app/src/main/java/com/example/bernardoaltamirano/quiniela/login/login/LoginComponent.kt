package com.example.bernardoaltamirano.quiniela.login.login

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector


@ScreenScope
@Subcomponent
interface LoginComponent: AndroidInjector<LoginController> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<LoginController>() {

    }
}