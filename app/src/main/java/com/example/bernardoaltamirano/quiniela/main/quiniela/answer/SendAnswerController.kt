package com.example.bernardoaltamirano.quiniela.main.quiniela.answer

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.main.quiniela.list.QuinielasAdapter
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_send_answer.view.*
import javax.inject.Inject

class SendAnswerController(args: Bundle): BaseController(args) {

    @Inject
    lateinit var presenter: SendAnswerPresenter
    @Inject
    lateinit var viewModel: SendAnswerViewModel
    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun layoutRes(): Int {
        return R.layout.screen_send_answer
    }

    override fun onViewBound(view: View) {
        view.bt_save.setOnClickListener {
            if (view.sp_match_1.selectedItemPosition != 0
                    && view.sp_match_2.selectedItemPosition != 0
                    && view.sp_match_2.selectedItemPosition != 0) {
                presenter.sendAnswer(view.sp_match_1.selectedItem as String, view.sp_match_2.selectedItem as String, view.sp_match_3.selectedItem as String)
            } else {
                Toast.makeText(view.context, "Debes de seleccionar un equipo para todos los partidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            view?.loading_indicator?.visibility = if (it) View.VISIBLE else View.GONE
                        },
                viewModel.quiniela()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            screenNavigator.pop()
                            screenNavigator.goToQuinielaDetails(it.id!!)
                        },
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it != "") {
                                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                            }
                        }
        )
    }

    companion object {

        const val QUINIELA_ID_KEY = "quiniela_id"

        fun newInstance(quinielaId: String): Controller {
            val bundle = Bundle()
            bundle.putString(QUINIELA_ID_KEY, quinielaId)
            return SendAnswerController(bundle)
        }
    }
}