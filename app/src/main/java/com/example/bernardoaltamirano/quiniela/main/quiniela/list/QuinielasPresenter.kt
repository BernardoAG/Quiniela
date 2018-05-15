package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRepository
import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRequester
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator
import javax.inject.Inject


@ScreenScope
class QuinielasPresenter @Inject constructor(private val viewModel: QuinielasViewModel,
                                             private val repository: QuinielaRepository,
                                             private val screenNavigator: ScreenNavigator): QuinielasAdapter.QuinielaClickedListener {

    init {
        //loadQuinielas()
    }

    override fun onQuinielaClicked(quiniela: Quiniela) {
        screenNavigator.goToQuinielaDetails(quiniela.id!!)
    }

    private fun loadQuinielas() {
        repository.getQuinielas()
                .doOnSubscribe { _ ->
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { _, _ ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.quinielasUpdated(), viewModel.onError())
    }
}