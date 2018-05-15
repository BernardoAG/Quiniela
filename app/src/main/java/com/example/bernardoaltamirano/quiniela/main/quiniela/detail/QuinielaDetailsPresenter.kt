package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import android.view.View
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.screen_quiniela_details.view.*
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class QuinielaDetailsPresenter @Inject constructor(@Named("quiniela_id") private val idQuiniela: String,
                                                   private val viewModel: QuinielaDetailsViewModel,
                                                   private val repository: QuinielaRepository): View.OnClickListener {

    init {
        repository.getQuiniela(idQuiniela)
                .doOnSuccess(viewModel.processQuiniela())
                .doOnError(viewModel.detailsError())
                .flatMap {
                    repository.getMembers(it.id!!)
                            .doOnError(viewModel.membersError())
                }
                .subscribe(viewModel.processMembers(), Consumer {
                    // We handle logging error on the view model.
                })
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.bt_join -> {

            }
        }
    }
}