package com.example.bernardoaltamirano.quiniela.data

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import timber.log.Timber

/**
 * Created by icaboalo on 21/02/18.
 */

data class ServerResponse<T>(var success: Boolean = false, var message: String = "", var result: T) {
    init {
        Timber.d("ServerResponse")
    }


    companion object {
        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(ServerResponse::class.java)
    }
}
