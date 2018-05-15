package com.example.bernardoaltamirano.quiniela.profile

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

@ScreenScope
@Subcomponent
interface ProfileComponent: AndroidInjector<ProfileController> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<ProfileController>() {
        @BindsInstance
        abstract fun bindUserId(@Named("user_id") userId: String)

        override fun seedInstance(instance: ProfileController?) {
            bindUserId("")
        }
    }
}