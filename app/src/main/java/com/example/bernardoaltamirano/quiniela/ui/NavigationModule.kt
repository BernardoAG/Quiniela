package com.example.bernardoaltamirano.quiniela.ui

import dagger.Binds
import dagger.Module

/**
 * Created by icaboalo on 02/02/18.
 */
@Module
abstract class NavigationModule {

    @Binds
    abstract fun provideScreenNavigator(screenNavigator: ScreenNavigatorImpl): ScreenNavigator
}