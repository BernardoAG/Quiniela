package com.example.bernardoaltamirano.quiniela.profile

import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.di.ControllerKey
import com.example.bernardoaltamirano.quiniela.profile.info.ProfileComponent
import com.example.bernardoaltamirano.quiniela.profile.info.ProfileController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    ProfileComponent::class
])
abstract class ProfileScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(ProfileController::class)
    abstract fun bindProfileController(builder: ProfileComponent.Builder): AndroidInjector.Factory<out Controller>
}