package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(private val requesterProvider: Provider<ProfileRequester>) {

    private val cachedUsers: HashMap<String, User> = HashMap()

    fun getProfile(id: String): Single<User> {
        return Maybe.concat(cachedUser(id), apiUser(id))
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
}