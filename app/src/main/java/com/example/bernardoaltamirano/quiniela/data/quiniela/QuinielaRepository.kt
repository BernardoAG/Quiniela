package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Provider
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.javax.inject.Singleton

@Singleton
class QuinielaRepository @Inject constructor(private val requesterProvider: Provider<QuinielaRequester>) {

    private val cachedQuinielas: ArrayList<Quiniela> = ArrayList()
    private val cachedMembers: HashMap<Long, List<User>> = HashMap()

    fun getQuinielas(): Single<List<Quiniela>> {
        return Maybe.concat(cachedQuinielas(), apiQuinielas())
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    fun getQuiniela(id: Long): Single<Quiniela> {
        return Maybe.concat(cachedQuiniela(id), apiQuiniela(id))
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    fun getMembers(id: Long): Single<List<User>> {
        return Maybe.concat(cachedMembers(id), apiMembers(id))
                .firstOrError()
                .subscribeOn(Schedulers.io())
    }

    private fun cachedQuiniela(id: Long): Maybe<Quiniela> {
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

    private fun apiQuiniela(id: Long): Maybe<Quiniela> {
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

    private fun cachedMembers(id: Long): Maybe<List<User>> {
        return Maybe.create {
            if (cachedMembers.containsKey(id)) {
                it.onSuccess(cachedMembers[id]!!)
            }
            it.onComplete()
        }
    }

    private fun apiMembers(id: Long): Maybe<List<User>> {
        return requesterProvider.get().getMembers(id)
                .doOnSuccess {
                    cachedMembers[id] = it
                }
                .toMaybe()
    }
}