package com.example.bernardoaltamirano.quiniela.profile.info

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent
interface ProfileComponent: AndroidInjector<ProfileController> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<ProfileController>() {
    }
}