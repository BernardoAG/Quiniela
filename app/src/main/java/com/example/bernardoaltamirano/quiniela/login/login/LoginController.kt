package com.example.bernardoaltamirano.quiniela.login.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_login.view.*
import javax.inject.Inject

class LoginController : BaseController() {

    @Inject
    lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var presenter: LoginPresenter

    override fun layoutRes(): Int {
        return R.layout.screen_login
    }

    override fun onViewBound(view: View) {
        view.bt_login.setOnClickListener {
            presenter.login(view.et_email.text.toString(), view.et_password.text.toString())
        }
        view.bt_register.setOnClickListener(presenter)
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