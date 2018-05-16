package com.example.bernardoaltamirano.quiniela.profile.info

import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_profile.view.*
import javax.inject.Inject

class ProfileController: BaseController() {

    @Inject
    lateinit var viewModel: ProfileViewModel
    @Inject
    lateinit var presenter: ProfilePresenter

    override fun layoutRes(): Int {
        return R.layout.screen_profile
    }

    override fun onViewBound(view: View) {
        view.bt_change_password.setOnClickListener {

        }
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
                            view!!.loading_indicator.visibility = if (it) View.VISIBLE else View.GONE
                        },
                viewModel.user()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            view!!.tv_name.text = it.name
                            view!!.tv_email.text = it.email
                        }
        )
    }
}