package com.example.bernardoaltamirano.quiniela.profile.info

import android.view.View
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.data.profile.ProfileRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class ProfilePresenter @Inject constructor(private val viewModel: ProfileViewModel,
                                           private val repository: ProfileRepository,
                                           private val screenNavigator: ScreenNavigator,
                                           @Named("uid") private val userId: String) : View.OnClickListener {

    init {
        getProfile()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.bt_change_password -> {
                screenNavigator.goToChangePassword()
            }
        }
    }

    fun getProfile() {
        repository.getProfile(userId)
                .doOnSubscribe { _ ->
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { _, _ ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.userUpdated(), viewModel.onError())
    }
}