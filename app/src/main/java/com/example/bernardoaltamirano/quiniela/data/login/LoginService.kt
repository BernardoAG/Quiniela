package com.example.bernardoaltamirano.quiniela.data.login

import com.example.bernardoaltamirano.quiniela.data.UserServerResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by icaboalo on 07/02/18.
 *
 * En esta clase se registra las URLS a las que se va a hacer una petición, dando como parámetros
 * lo que el servidor necesita y un tipo de respuesta.
 */
interface LoginService {

    @POST("login/")
    fun login(@Body body: RequestBody): Single<UserServerResponse>

    @POST("register/")
    fun register(@Body body: RequestBody): Single<UserServerResponse>
}