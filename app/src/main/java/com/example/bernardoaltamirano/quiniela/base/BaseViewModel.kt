package com.example.bernardoaltamirano.quiniela.base

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import timber.log.Timber

abstract class BaseViewModel {

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
}