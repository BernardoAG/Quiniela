package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Clase de patrón repositorio para manejar información local y del servidor.
 * En esta clase se elige primero obtener la información del servidor
 * y en caso de que no se pudiera obtener va a cargar la información previamente almacenada
 */
@Singleton
class ProfileRepository @Inject constructor(private val requesterProvider: Provider<ProfileRequester>) {

    private val cachedUsers: HashMap<String, User> = HashMap()

    fun getProfile(id: String): Single<User> {
        return Maybe.concat(cachedUser(id), apiUser(id))
                .subscribeOn(Schedulers.io())
                .firstOrError()
    }

    fun changePassword(id: String, newPassword: String, oldPassword: String): Single<User> {
        return Maybe.concat(apiChangePassword(id, newPassword, oldPassword), apiChangePassword(id, newPassword, oldPassword))
                .subscribeOn(Schedulers.io())
                .firstOrError()
    }

    private fun cachedUser(id: String): Maybe<User> {
        return Maybe.create {
            if (cachedUsers.containsKey(id)) {
                it.onSuccess(cachedUsers[id]!!)
            }
            it.onComplete()
        }
    }

    private fun apiUser(id: String): Maybe<User> {
        return requesterProvider.get()
                .getProfile(id)
                .doOnSuccess {
                    cachedUsers[id] = it
                }
                .toMaybe()
    }

    private fun apiChangePassword(id: String, newPassword: String, oldPassword: String): Maybe<User> {
        return requesterProvider.get()
                .changePassword(id, newPassword, oldPassword)
                .toMaybe()
    }
}