package com.example.bernardoaltamirano.quiniela.main.quiniela.add

import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject

@ScreenScope
class AddQuinielaPresenter @Inject constructor(private val viewModel: AddQuinielaViewModel,
                                               private val repository: QuinielaRepository) {

    fun createQuiniela(name: String, price: Double) {
        repository.createQuiniela(name, price)
                .doOnSubscribe {
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { t1, t2 ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.quinielaUpdated(), viewModel.onError())
    }
}