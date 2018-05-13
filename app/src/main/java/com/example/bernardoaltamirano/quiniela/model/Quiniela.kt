package com.example.bernardoaltamirano.quiniela.model

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Quiniela(@PrimaryKey var id: Long? = null, var price: Double? = null,
                    var name: String? = null, var members: Int? = null): RealmObject() {


    companion object {
        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(Quiniela::class.java)
    }
}