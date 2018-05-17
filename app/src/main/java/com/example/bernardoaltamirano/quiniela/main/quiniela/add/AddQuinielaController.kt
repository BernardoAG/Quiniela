package com.example.bernardoaltamirano.quiniela.main.quiniela.add

import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_add_quiniela.view.*
import javax.inject.Inject

class AddQuinielaController : BaseController() {

    @Inject
    lateinit var viewModel: AddQuinielaViewModel
    @Inject
    lateinit var presenter: AddQuinielaPresenter
    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun layoutRes(): Int {
        return R.layout.screen_add_quiniela
    }

    override fun onViewBound(view: View) {
        view.bt_save.setOnClickListener {
            if (view.et_name.text.toString().isNotEmpty() && view.et_price.text.toString().isNotEmpty()) {
                presenter.createQuiniela(view.et_name.text.toString(), view.et_price.text.toString().toDouble())
            } else {
                Toast.makeText(view.context, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
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
                viewModel.quiniela()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            screenNavigator.pop()
                            screenNavigator.gotoSendAnswer(it.id!!)
                        }
        )
    }
}