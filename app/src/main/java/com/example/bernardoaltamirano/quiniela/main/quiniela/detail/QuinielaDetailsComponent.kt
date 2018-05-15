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
        abstract fun bindQuinielaId(@Named("quiniela_id") quinielaId: String)


        override fun seedInstance(instance: QuinielaDetailsController?) {
            bindQuinielaId(instance?.args!!.getString(QuinielaDetailsController.QUINIELA_ID_KEY))
        }
    }
}