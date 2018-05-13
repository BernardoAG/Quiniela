package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_quinielas.view.*
import javax.inject.Inject

class QuinielasController : BaseController() {

    @Inject
    lateinit var presenter: QuinielasPresenter
    @Inject
    lateinit var viewModel: QuinielasViewModel

    override fun layoutRes(): Int {
        return R.layout.screen_quinielas
    }

    override fun onViewBound(view: View) {
        view.rv_quinielas.layoutManager = LinearLayoutManager(view.context)
        view.rv_quinielas.adapter = QuinielasAdapter(presenter)
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            view?.loading_indicator?.visibility = if (it) View.VISIBLE else View.GONE
                            view?.rv_quinielas?.visibility = if (it) View.GONE else View.VISIBLE
                        },
                viewModel.quinielas()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            (view?.rv_quinielas?.adapter as QuinielasAdapter).setData(it)
                        },
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it != -1) {
                                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                            }
                        }
        )
    }
}