package com.example.bernardoaltamirano.quiniela.login.register

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent
interface RegisterComponent: AndroidInjector<RegisterController> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<RegisterController>() {

    }
}