package com.example.bernardoaltamirano.quiniela.main

import com.example.bernardoaltamirano.quiniela.MainActivity
import com.example.bernardoaltamirano.quiniela.di.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent()
interface MainActivityComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>() {

    }
}