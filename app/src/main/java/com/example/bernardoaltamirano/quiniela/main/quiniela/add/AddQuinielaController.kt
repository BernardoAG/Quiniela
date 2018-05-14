package com.example.bernardoaltamirano.quiniela.main.quiniela.add

import android.view.View
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AddQuinielaController : BaseController() {

    @Inject
    lateinit var viewModel: AddQuinielaViewModel
    @Inject
    lateinit var presenter: AddQuinielaPresenter

    override fun layoutRes(): Int {
        return R.layout.screen_add_quiniela
    }

    override fun onViewBound(view: View) {

    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {

                        },
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {

                        },
                viewModel.quiniela()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {

                        }
        )
    }
}