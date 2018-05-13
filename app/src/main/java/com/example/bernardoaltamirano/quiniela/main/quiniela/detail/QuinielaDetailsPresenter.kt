package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import io.reactivex.functions.Consumer
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.javax.inject.Named

@ScreenScope
class QuinielaDetailsPresenter @Inject constructor(@Named("quiniela_id") private val idQuiniela: Long,
                                                   private val viewModel: QuinielaDetailsViewModel,
                                                   private val repository: QuinielaRepository) {

    init {
        repository.getQuiniela(idQuiniela)
                .doOnSuccess(viewModel.processQuiniela())
                .doOnError(viewModel.detailsError())
                .flatMap {
                    repository.getMembers(it.id)
                            .doOnError(viewModel.membersError())
                }
                .subscribe(viewModel.processMembers(), Consumer {
                    // We handle logging error on the view model.
                })
    }
}