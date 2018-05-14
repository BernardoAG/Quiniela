package com.example.bernardoaltamirano.quiniela.login.login

import com.example.bernardoaltamirano.quiniela.base.BaseViewModel
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.User
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@ScreenScope
class LoginViewModel @Inject constructor(): BaseViewModel() {

    private val userRelay: BehaviorRelay<User> = BehaviorRelay.create()

    fun user(): Observable<User> {
        return userRelay
    }

    fun userUpdated(): Consumer<User> {
        return userRelay
    }
}