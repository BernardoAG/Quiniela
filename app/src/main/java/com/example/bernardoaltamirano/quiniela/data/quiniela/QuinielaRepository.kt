package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class QuinielaRepository @Inject constructor(private val requesterProvider: Provider<QuinielaRequester>) {

    private val cachedQuinielas: ArrayList<Quiniela> = ArrayList()
    private val cachedMembers: HashMap<String, List<User>> = HashMap()

    fun getQuinielas(): Single<List<Quiniela>> {
        return Maybe.concat(apiQuinielas(), cachedQuinielas())
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    fun getQuiniela(id: String): Single<Quiniela> {
        return Maybe.concat(apiQuiniela(id), cachedQuiniela(id))
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    fun getMembers(id: String): Single<List<User>> {
        return Maybe.concat(apiMembers(id), cachedMembers(id))
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    fun createQuiniela(name: String, price: Double): Single<Quiniela> {
        return requesterProvider.get().createQuiniela(name, price)
                .subscribeOn(Schedulers.io())
    }

    fun sendAnswer(quinielaId: String, userName: String, userId: String, match1: String, match2: String, match3: String): Single<Quiniela> {
        return requesterProvider.get().sendAnswer(quinielaId, userId, userName, match1, match2, match3)
                .subscribeOn(Schedulers.io())
    }

    fun deleteAnswer(quinielaId: String, userId: String): Single<Quiniela> {
        return requesterProvider.get().deleteAnswer(quinielaId, userId)
                .subscribeOn(Schedulers.io())
    }

    private fun cachedQuiniela(id: String): Maybe<Quiniela> {
        return Maybe.create {
            for (quiniela: Quiniela in cachedQuinielas) {
                if (quiniela.id == id) {
                    it.onSuccess(quiniela)
                    break
                }
            }
            it.onComplete()
        }
    }

    private fun apiQuiniela(id: String): Maybe<Quiniela> {
        return requesterProvider.get()
                .getQuiniela(id)
                .toMaybe()
    }

    private fun cachedQuinielas(): Maybe<List<Quiniela>> {
        return Maybe.create {
            if (cachedQuinielas.isNotEmpty()) {
                it.onSuccess(cachedQuinielas)
            }
            it.onComplete()
        }
    }

    private fun apiQuinielas(): Maybe<List<Quiniela>> {
        return requesterProvider.get().getQuinielas()
                .doOnSuccess {
                    cachedQuinielas.clear()
                    cachedQuinielas.addAll(it)
                }
                .toMaybe()
    }

    private fun cachedMembers(id: String): Maybe<List<User>> {
        return Maybe.create {
            if (cachedMembers.containsKey(id)) {
                it.onSuccess(cachedMembers[id]!!)
            }
            it.onComplete()
        }
    }

    private fun apiMembers(id: String): Maybe<List<User>> {
        return requesterProvider.get().getMembers(id)
                .doOnSuccess {
                    cachedMembers[id] = it
                }
                .toMaybe()
    }
}