package com.example.bernardoaltamirano.quiniela.main

import android.content.SharedPreferences
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.di.ControllerKey
import com.example.bernardoaltamirano.quiniela.main.quiniela.add.AddQuinielaComponent
import com.example.bernardoaltamirano.quiniela.main.quiniela.add.AddQuinielaController
import com.example.bernardoaltamirano.quiniela.main.quiniela.answer.SendAnswerComponent
import com.example.bernardoaltamirano.quiniela.main.quiniela.answer.SendAnswerController
import com.example.bernardoaltamirano.quiniela.main.quiniela.detail.QuinielaDetailsController
import com.example.bernardoaltamirano.quiniela.main.quiniela.detail.QuinielaDetailsComponent
import com.example.bernardoaltamirano.quiniela.main.quiniela.list.QuinielasComponent
import com.example.bernardoaltamirano.quiniela.main.quiniela.list.QuinielasController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named

/**
 * Created by icaboalo on 01/02/18.
 */

@Module(subcomponents = [
    QuinielasComponent::class,
    QuinielaDetailsComponent::class,
    AddQuinielaComponent::class,
    SendAnswerComponent::class
])
abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(QuinielasController::class)
    abstract fun bindQuinielasInjector(builder: QuinielasComponent.Builder): AndroidInjector.Factory<out Controller>

    @Binds
    @IntoMap
    @ControllerKey(QuinielaDetailsController::class)
    abstract fun bindQuinielaDetailsInjector(builder: QuinielaDetailsComponent.Builder): AndroidInjector.Factory<out Controller>

    @Binds
    @IntoMap
    @ControllerKey(AddQuinielaController::class)
    abstract fun bindAddQuinielaInjector(builder: AddQuinielaComponent.Builder): AndroidInjector.Factory<out Controller>

    @Binds
    @IntoMap
    @ControllerKey(SendAnswerController::class)
    abstract fun bindSendAnswerInjector(builder: SendAnswerComponent.Builder): AndroidInjector.Factory<out Controller>
}
