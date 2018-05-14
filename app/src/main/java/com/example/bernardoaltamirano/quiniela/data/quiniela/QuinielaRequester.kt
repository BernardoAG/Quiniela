package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject

class QuinielaRequester @Inject constructor(private val service: QuinielaService) {

    fun getQuinielas(): Single<List<Quiniela>> {
        return service.getQuinielas()
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<List<Quiniela>>(ServerError(it.message))
                    }
                }
    }

    fun getQuiniela(id: Long): Single<Quiniela> {
        return service.getQuiniela(id)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<Quiniela>(ServerError(it.message))
                    }
                }
    }

    fun getMembers(id: Long): Single<List<User>> {
        return service.getMembers(id)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<List<User>>(ServerError(it.message))
                    }
                }
    }
}