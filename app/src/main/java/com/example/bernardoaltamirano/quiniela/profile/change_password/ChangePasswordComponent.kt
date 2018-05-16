package com.example.bernardoaltamirano.quiniela.profile.change_password

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent
interface ChangePasswordComponent : AndroidInjector<ChangePasswordController> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ChangePasswordController>()
}