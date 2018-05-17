package com.example.bernardoaltamirano.quiniela.main.quiniela.answer

import com.example.bernardoaltamirano.quiniela.base.BaseViewModel
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

@ScreenScope
class SendAnswerViewModel @Inject constructor(): BaseViewModel() {

    private val quinielaRelay: BehaviorRelay<Quiniela> = BehaviorRelay.create()

    fun quiniela(): Observable<Quiniela> {
        return quinielaRelay
    }

    fun quinielaUpdated(): Consumer<Quiniela> {
        return quinielaRelay
    }
}