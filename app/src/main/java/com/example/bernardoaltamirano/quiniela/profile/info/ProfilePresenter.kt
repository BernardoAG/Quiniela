package com.example.bernardoaltamirano.quiniela.profile.info

import android.content.SharedPreferences
import com.example.bernardoaltamirano.quiniela.data.profile.ProfileRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject

@ScreenScope
class ProfilePresenter @Inject constructor(private val viewModel: ProfileViewModel,
                                           private val repository: ProfileRepository,
                                           private val sharedPreferences: SharedPreferences) {

    init {
        getProfile()
    }

    fun getProfile() {
        repository.getProfile(sharedPreferences.getString("uid", "123"))
                .doOnSubscribe { _ ->
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { _, _ ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.userUpdated(), viewModel.onError())
    }
}