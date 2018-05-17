package com.example.bernardoaltamirano.quiniela.model

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.realm.annotations.PrimaryKey

data class Quiniela(@PrimaryKey var id: String? = null, var price: Double? = null,
                    var name: String? = null, var members: Int? = null) {


    companion object {
        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(Quiniela::class.java)
    }
}