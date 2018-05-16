package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
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

    fun changePassword(userId: String, newPassword: String, oldPassword: String): Single<User> {
        val json = JSONObject()
                .put("new_password", newPassword)
                .put("old_password", oldPassword)

        val body = RequestBody.create(MediaType.parse("application/json"), json.toString())

        return service.changePassword(userId, body)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
    }
}