package com.example.bernardoaltamirano.quiniela.profile.change_password

import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_change_password.view.*
import timber.log.Timber
import javax.inject.Inject

class ChangePasswordController: BaseController() {

    @Inject
    lateinit var viewModel: ChangePasswordViewModel
    @Inject
    lateinit var presenter: ChangePasswordPresenter
    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun layoutRes(): Int {
        return R.layout.screen_change_password
    }

    override fun onViewBound(view: View) {
        view.bt_change_password.setOnClickListener {
            if (view.et_password.text.isNotEmpty() && view.et_old_password.text.isNotEmpty() && view.et_confirm_password.text.isNotEmpty()) {
                if (view.et_password.text.toString() == view.et_confirm_password.text.toString()) {
                    presenter.changePassword(view.et_password.text.toString(), view.et_old_password.text.toString())
                } else {
                    Toast.makeText(view.context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(view.context, "Debes de llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            Timber.d(it)
                            if (it != "") {
                                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                            }
                        },
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            Timber.d("$it")
                            view!!.loading_indicator.visibility = if (it) View.VISIBLE else View.GONE
                        },
                viewModel.password()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            screenNavigator.pop()
                        }
        )
    }
}