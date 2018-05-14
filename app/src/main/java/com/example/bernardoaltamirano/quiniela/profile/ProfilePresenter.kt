package com.example.bernardoaltamirano.quiniela.profile

import com.example.bernardoaltamirano.quiniela.data.profile.ProfileRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class ProfilePresenter @Inject constructor(@Named("user_id") userId: String,
                                           private val viewModel: ProfileViewModel,
                                           private val repository: ProfileRepository) {

    init {
        getProfile(userId)
    }

    fun getProfile(id: String) {
        repository.getProfile(id)
                .doOnSubscribe { _ ->
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { _, _ ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.userUpdated(), viewModel.onError())
    }
}