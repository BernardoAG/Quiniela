package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseController
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.screen_quiniela_details.view.*
import javax.inject.Inject

class QuinielaDetailsController(bundle: Bundle) : BaseController(bundle) {

    @Inject
    lateinit var viewModel: QuinielaDetailsViewModel
    @Inject
    lateinit var presenter: QuinielaDetailsPresenter

    override fun layoutRes(): Int {
        return R.layout.screen_quiniela_details
    }

    override fun onViewBound(view: View) {
        view.rv_members.layoutManager = LinearLayoutManager(view.context)
        view.rv_members.adapter = MembersAdapter()

        (view.rv_members.adapter as MembersAdapter).setData(arrayListOf(
                User(123, "Bernardo", "bernardo"),
                User(124, "Iñaki", "icabo")
        ))
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.details()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it.loading) {
                                view!!.loading_indicator!!.visibility = View.VISIBLE
                                view!!.content_container!!.visibility = View.GONE
                            } else {
                                view!!.loading_indicator!!.visibility = View.GONE
                                view!!.content_container!!.visibility = View.VISIBLE
                                if (!it.isSuccess()) {
                                    Toast.makeText(activity, it.error, Toast.LENGTH_SHORT).show()
                                }
                                view!!.tv_quiniela_name.text = it.name
                                view!!.tv_members.text = "Integrantes: ${it.members}"
                            }
                        },
                viewModel.members()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            if (it.loading) {
                                view!!.members_loading_indicator!!.visibility = View.VISIBLE
                                view!!.rv_members!!.visibility = View.GONE
                            } else {
                                view!!.members_loading_indicator!!.visibility = View.GONE
                                view!!.rv_members!!.visibility = View.VISIBLE
                                if (!it.isSuccess()) {
                                    Toast.makeText(activity, it.error, Toast.LENGTH_SHORT).show()
                                } else {
                                    (view!!.rv_members.adapter as MembersAdapter).setData(it.members)
                                }

                            }
                        }
        )
    }

    companion object {
        const val QUINIELA_ID_KEY = "quiniela_id"

        fun newInstance(quinielaId: Long): Controller {
            val bundle = Bundle()
            bundle.putLong(QUINIELA_ID_KEY, quinielaId)
            return QuinielaDetailsController(bundle)
        }
    }

}
