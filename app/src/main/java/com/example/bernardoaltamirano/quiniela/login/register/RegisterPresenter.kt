package com.example.bernardoaltamirano.quiniela.login.register

import com.example.bernardoaltamirano.quiniela.data.login.LoginRequester
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject

@ScreenScope
class RegisterPresenter @Inject constructor(private val viewModel: RegisterViewModel, private val requester: LoginRequester) {

    fun register(username: String, password: String, name: String) {
        requester.register(username, password, name)
                .doOnSubscribe {
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { _, _ ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.userUpdated(), viewModel.onError())
    }
}