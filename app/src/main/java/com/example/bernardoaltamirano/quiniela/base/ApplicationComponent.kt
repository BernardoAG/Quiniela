package com.example.bernardoaltamirano.quiniela.base

import dagger.Component

@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {
    fun inject(myApplication: MyApplication)
}