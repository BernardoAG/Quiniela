package com.example.bernardoaltamirano.quiniela.login.register

import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_login.view.*
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

class RegisterController : BaseController() {

    @Inject
    lateinit var viewModel: RegisterViewModel
    @Inject
    lateinit var presenter: RegisterPresenter

    override fun layoutRes(): Int {
        return R.layout.screen_register
    }

    override fun onViewBound(view: View) {

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
                            // TODO MOVE TO NEW SCREEN
                        }
        )
    }
}