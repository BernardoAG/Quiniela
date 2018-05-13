package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import com.example.bernardoaltamirano.quiniela.base.BaseViewModel
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

@ScreenScope
class QuinielasViewModel @Inject constructor(): BaseViewModel() {


    private val quinielasRelay: BehaviorRelay<List<Quiniela>> = BehaviorRelay.create()

    fun quinielas(): Observable<List<Quiniela>> {
        return quinielasRelay
    }

    fun quinielasUpdated(): Consumer<List<Quiniela>> {
        return quinielasRelay
    }
}