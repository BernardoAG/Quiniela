package com.example.bernardoaltamirano.quiniela.main.quiniela.add

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
@ScreenScope
interface AddQuinielaComponent: AndroidInjector<AddQuinielaController> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<AddQuinielaController>() {

    }
}