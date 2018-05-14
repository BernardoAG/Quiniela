package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import javax.inject.Inject

class ProfileRequester @Inject constructor(private val service: ProfileService) {

    fun getProfile(id: String): Single<User> {
        return service.getProfile(id)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
    }
}