package com.example.bernardoaltamirano.quiniela.data.login

import android.content.SharedPreferences
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.ServerError
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by icaboalo on 07/02/18.
 *
 * Clase encargada de enviar peticiones al servidor únicamente para servicios de login
 * Aqui se tienen registradas dos funciones: login y register
 *
 * Cada una parsea la información como el servidor la necesita recibir y llama la información
 */
class LoginRequester @Inject constructor(private val service: LoginService,
                                         private val sharedPreferences: SharedPreferences) {

    fun login(username: String, password: String): Single<User> {
        val json = JSONObject()
                .put("email", username)
                .put("password", password)
        Timber.d(json.toString())
        val body = RequestBody.create(MediaType.parse("application/json"), json.toString())
        return service.login(body)
                .flatMap {
                    if (it.success) {
                        sharedPreferences.edit().putString("uid", it.result!!.id).apply()
                        sharedPreferences.edit().putString("u_name", it.result.name).apply()
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
                .subscribeOn(Schedulers.io())
    }

    fun register(username: String, password: String, name: String): Single<User> {
        val json = JSONObject()
                .put("email", username)
                .put("password", password)
                .put("name", name)
        Timber.d(json.toString())
        val body = RequestBody.create(MediaType.parse("application/json"), json.toString())
        return service.register(body)
                .flatMap {
                    if (it.success) {
                        sharedPreferences.edit().putString("uid", it.result!!.id).apply()
                        sharedPreferences.edit().putString("u_name", it.result.name).apply()
                        return@flatMap Single.just(it.result)
                    } else {
                        return@flatMap Single.error<User>(ServerError(it.message))
                    }
                }
                .subscribeOn(Schedulers.io())
    }
}