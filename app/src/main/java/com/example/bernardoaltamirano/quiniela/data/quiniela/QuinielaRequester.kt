package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject

class QuinielaRequester @Inject constructor(private val service: QuinielaService) {

    fun getQuinielas(): Single<List<Quiniela>> {
        return service.getQuinielas()
                .map(ServerResponse<List<Quiniela>>::result)
    }

    fun getQuiniela(id: Long): Single<Quiniela> {
        return service.getQuiniela(id)
                .map(ServerResponse<Quiniela>::result)
    }

    fun getMembers(id: Long): Single<List<User>> {
        return service.getMembers(id)
                .map(ServerResponse<List<User>>::result)
    }
}