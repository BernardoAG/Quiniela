package com.example.bernardoaltamirano.quiniela.model

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

data class Quiniela(val id: Long, val price: Double, val name: String, val members: Int) {


    companion object {
        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(ServerResponse::class.java)
    }
}