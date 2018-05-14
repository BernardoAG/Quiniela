package com.example.bernardoaltamirano.quiniela.profile

import com.example.bernardoaltamirano.quiniela.di.ActivityScope
import com.example.bernardoaltamirano.quiniela.ui.NavigationModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [
    ProfileScreenBindingModule::class,
    NavigationModule::class
])
interface ProfileActivityComponent: AndroidInjector<ProfileActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<ProfileActivity>()
}