package com.example.bernardoaltamirano.quiniela.main.quiniela.answer

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.Binds
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

@ScreenScope
@Subcomponent
interface SendAnswerComponent: AndroidInjector<SendAnswerController> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<SendAnswerController>() {

        @BindsInstance
        abstract fun bindQuinielaId(@Named("quiniela_id") quinielaId: String)

        override fun seedInstance(instance: SendAnswerController?) {
            bindQuinielaId(instance?.args!!.getString(SendAnswerController.QUINIELA_ID_KEY))
        }
    }
}