package com.example.bernardoaltamirano.quiniela.data.login

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by icaboalo on 07/02/18.
 */
class LoginRequester @Inject constructor(private val service: LoginService, private val realm: Realm) {

    fun login(username: String, password: String): Single<User> {
        val json = JSONObject()
                .put("username", username)
                .put("password", password)
        Timber.d(json.toString())
        val body = ResponseBody.create(MediaType.parse("application/json"), json.toString())
        return service.login(body)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
                .doOnSuccess {
                    realm.beginTransaction()
                    realm.copyToRealm(it)
                    realm.commitTransaction()
                }
                .subscribeOn(Schedulers.io())
    }

    fun register(username: String, password: String, name: String): Single<User> {
        val json = JSONObject()
                .put("username", username)
                .put("password", password)
                .put("name", name)
        Timber.d(json.toString())
        val body = ResponseBody.create(MediaType.parse("application/json"), json.toString())
        return service.register(body)
                .flatMap {
                    if (it.success) {
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
                .subscribeOn(Schedulers.io())
    }
}