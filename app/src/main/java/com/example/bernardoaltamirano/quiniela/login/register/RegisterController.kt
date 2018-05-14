package com.example.bernardoaltamirano.quiniela.login.register

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_register.view.*
import javax.inject.Inject

class RegisterController : BaseController() {

    @Inject
    lateinit var viewModel: RegisterViewModel
    @Inject
    lateinit var presenter: RegisterPresenter

    override fun layoutRes(): Int {
        return R.layout.screen_register
    }

    override fun onViewBound(view: View) {
        view.bt_register.setOnClickListener {
            if (view.et_password.text.toString() == view.et_confirm_password.text.toString()) {
                presenter.register(view.et_email.text.toString(), view.et_password.text.toString(), view.et_name.text.toString())
            } else {
                Toast.makeText(view.context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it != -1) {
                                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                            }
                        },
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            view?.loading_indicator?.visibility = if (it) View.VISIBLE else View.GONE
                        },
                viewModel.user()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            activity?.startActivity(Intent(activity, MainActivity::class.java))
                            activity?.finish()
                        }
        )
    }
}