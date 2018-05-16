package com.example.bernardoaltamirano.quiniela.profile.info

import com.example.bernardoaltamirano.quiniela.base.BaseViewModel
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.User
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

@ScreenScope
class ProfileViewModel @Inject constructor() : BaseViewModel() {
    private val userRelay: BehaviorRelay<User> = BehaviorRelay.create()

    fun user(): Observable<User> {
        return userRelay
    }

    fun userUpdated(): Consumer<User> {
        return userRelay
    }
}