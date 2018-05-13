package com.example.bernardoaltamirano.quiniela.login.login

import android.view.View
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.data.login.LoginRequester
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import javax.inject.Inject

@ScreenScope
class LoginPresenter @Inject constructor(private val viewModel: LoginViewModel, private val requester: LoginRequester, private val screenNavigator: ScreenNavigator): View.OnClickListener {

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.bt_login -> {

            }
            R.id.bt_register -> {
                screenNavigator.goToRegister()
            }
        }
    }

    fun login(username: String, password: String) {
        requester.login(username, password)
                .doOnSubscribe {
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { t1, t2 ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.userUpdated())
    }
}