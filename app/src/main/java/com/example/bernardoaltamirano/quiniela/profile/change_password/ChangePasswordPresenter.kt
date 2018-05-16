package com.example.bernardoaltamirano.quiniela.profile.change_password

import com.example.bernardoaltamirano.quiniela.data.profile.ProfileRepository
import com.example.bernardoaltamirano.quiniela.data.profile.ProfileRequester
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class ChangePasswordPresenter @Inject constructor(private val viewModel: ChangePasswordViewModel, private val repository: ProfileRepository, @Named("uid") private val userId: String) {

    fun changePassword(newPassword: String, oldPassword: String) {
        repository.changePassword(userId, newPassword, oldPassword)
                .doOnSubscribe {
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { t1, t2 ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.passwordUpdated(), viewModel.onError())
    }
}