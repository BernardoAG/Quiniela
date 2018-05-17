package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.UserServerResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

/**
* En esta clase se registra las URLS a las que se va a hacer una petición, dando como parámetros
* lo que el servidor necesita y un tipo de respuesta.
*/
interface ProfileService {

    @GET("getUser/")
    fun getProfile(@Query("id") id: String): Single<UserServerResponse>

    @PUT("changePassword/")
    fun changePassword(@Query("id") id: String, @Body body: RequestBody): Single<UserServerResponse>
}