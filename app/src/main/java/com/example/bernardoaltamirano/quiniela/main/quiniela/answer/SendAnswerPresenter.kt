package com.example.bernardoaltamirano.quiniela.main.quiniela.answer

import com.example.bernardoaltamirano.quiniela.data.quiniela.QuinielaRepository
import com.example.bernardoaltamirano.quiniela.di.ScreenScope
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class SendAnswerPresenter @Inject constructor(private val viewModel: SendAnswerViewModel,
                                              private val repository: QuinielaRepository,
                                              @Named("uid") private val userId: String,
                                              @Named("u_name") private val userName: String,
                                              @Named("quiniela_id") private val quinielaId: String) {

    fun sendAnswer(match1: String, match2: String, match3: String) {
        repository.sendAnswer(quinielaId, userName, userId, match1, match2, match3)
                .doOnSubscribe {
                    viewModel.loadingUpdated().accept(true)
                }
                .doOnEvent { t1, t2 ->
                    viewModel.loadingUpdated().accept(false)
                }
                .subscribe(viewModel.quinielaUpdated(), viewModel.onError())
    }
}