package com.example.bernardoaltamirano.quiniela.base

import com.example.bernardoaltamirano.quiniela.util.ServerError
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import timber.log.Timber

abstract class BaseViewModel {

    private val errorRelay: BehaviorRelay<String> = BehaviorRelay.create()
    private val loadingRelay: BehaviorRelay<Boolean> = BehaviorRelay.create()

    fun loading(): Observable<Boolean> {
        return loadingRelay
    }

    fun error(): Observable<String> {
        return errorRelay
    }

    fun loadingUpdated(): Consumer<Boolean> {
        errorRelay.accept("")
        return loadingRelay
    }

    fun onError(): Consumer<Throwable> {
        return Consumer {
            Timber.e(it, "Error")
            if (it is ServerError) {
                errorRelay.accept(it.message)
            } else {
                errorRelay.accept("Ocurrió un error inesperado.")
            }
        }
    }
}