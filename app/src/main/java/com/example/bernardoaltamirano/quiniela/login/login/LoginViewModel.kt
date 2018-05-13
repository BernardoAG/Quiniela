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
class LoginViewModel @Inject constructor() {

    private val userRelay: BehaviorRelay<User> = BehaviorRelay.create()

    private val errorRelay: BehaviorRelay<Int> = BehaviorRelay.create()
    private val loadingRelay: BehaviorRelay<Boolean> = BehaviorRelay.create()

    fun loading(): Observable<Boolean> {
        return loadingRelay
    }

    fun error(): Observable<Int> {
        return errorRelay
    }

    fun loadingUpdated(): Consumer<Boolean> {
        errorRelay.accept(-1)
        return loadingRelay
    }

    fun onError(): Consumer<Throwable> {
        return Consumer {
            Timber.e(it, "Error")
            errorRelay.accept(0)
        }
    }

    fun user(): Observable<User> {
        return userRelay
    }

    fun userUpdated(): Consumer<User> {
        return userRelay
    }
}