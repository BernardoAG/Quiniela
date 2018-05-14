package com.example.bernardoaltamirano.quiniela.profile

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_login.view.*
import javax.inject.Inject

class ProfileController: BaseController() {

    @Inject
    lateinit var viewModel: ProfileViewModel
    @Inject
    lateinit var presenter: ProfilePresenter

    override fun layoutRes(): Int {
        return 0
    }

    override fun onViewBound(view: View) {
        super.onViewBound(view)
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it != "") {
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

                        }
        )
    }
}