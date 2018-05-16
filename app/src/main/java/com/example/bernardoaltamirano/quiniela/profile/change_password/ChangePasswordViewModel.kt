package com.example.bernardoaltamirano.quiniela.profile.change_password

import com.example.bernardoaltamirano.quiniela.base.BaseViewModel
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.User
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

@ScreenScope
class ChangePasswordViewModel @Inject constructor(): BaseViewModel() {

    private val passwordRelay: BehaviorRelay<User> = BehaviorRelay.create()

    fun password(): Observable<User> {
        return passwordRelay
    }

    fun passwordUpdated(): Consumer<User?> {
        return passwordRelay
    }
}