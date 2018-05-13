package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent()
interface QuinielasComponent: AndroidInjector<QuinielasController> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<QuinielasController>()
}