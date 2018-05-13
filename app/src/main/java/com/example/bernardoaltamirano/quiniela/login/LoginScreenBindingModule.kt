package com.example.bernardoaltamirano.quiniela.login

import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.di.ControllerKey
import com.example.bernardoaltamirano.quiniela.login.login.LoginComponent
import com.example.bernardoaltamirano.quiniela.login.login.LoginController
import com.example.bernardoaltamirano.quiniela.login.register.RegisterComponent
import com.example.bernardoaltamirano.quiniela.login.register.RegisterController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    LoginComponent::class,
    RegisterComponent::class
])
abstract class LoginScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(LoginController::class)
    abstract fun bindLoginController(builder: LoginComponent.Builder): AndroidInjector.Factory<out Controller>

    @Binds
    @IntoMap
    @ControllerKey(RegisterController::class)
    abstract fun bindRegisterController(builder: RegisterComponent.Builder): AndroidInjector.Factory<out Controller>
}