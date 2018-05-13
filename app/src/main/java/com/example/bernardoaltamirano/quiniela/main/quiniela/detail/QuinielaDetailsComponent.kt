package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named


@ScreenScope
@Subcomponent
interface QuinielaDetailsComponent: AndroidInjector<QuinielaDetailsController> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<QuinielaDetailsController>() {

        @BindsInstance
        abstract fun bindQuinielaId(@Named("quiniela_id") quinielaId: Long)


        override fun seedInstance(instance: QuinielaDetailsController?) {
            bindQuinielaId(instance?.args!!.getLong(QuinielaDetailsController.QUINIELA_ID_KEY))
        }
    }
}