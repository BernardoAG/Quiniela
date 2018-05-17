package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
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

    fun getQuiniela(id: String): Single<Quiniela> {
        return service.getQuiniela(id)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<Quiniela>(ServerError(it.message))
                    }
                }
    }

    fun getMembers(id: String): Single<List<User>> {
        return service.getMembers(id)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<List<User>>(ServerError(it.message))
                    }
                }
    }

    fun createQuiniela(name: String, price: Double): Single<Quiniela> {
        val json = JSONObject()
                .put("name", name)
                .put("price", price)
        return service.createQuiniela(RequestBody.create(MediaType.parse("application/json"), json.toString()))
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<Quiniela>(ServerError(it.message))
                    }
                }
    }

    fun sendAnswer(quinielaId: String, userId: String, userName: String, partido_1: String, partido_2: String, partido_3: String): Single<Quiniela> {
        val json = JSONObject()
                .put("user_id", userId)
                .put("name", userName)
                .put("partido_1", partido_1)
                .put("partido_2", partido_2)
                .put("partido_3", partido_3)

        return service.sendAnswer(quinielaId, RequestBody.create(MediaType.parse("application/json"), json.toString()))
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<Quiniela>(ServerError(it.message))
                    }
                }
    }

    fun deleteAnswer(quinielaId: String, userId: String): Single<Quiniela> {
        return service.deleteAnswer(quinielaId, userId)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<Quiniela>(ServerError(it.message))
                    }
                }
    }
}