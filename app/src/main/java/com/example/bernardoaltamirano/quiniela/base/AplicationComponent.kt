package com.example.bernardoaltamirano.quiniela.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
ApplicationModule::class
])
interface AplicationComponent {
    fun inject(myApplication: MyApplication)
}