package com.example.bernardoaltamirano.quiniela.data.login

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by icaboalo on 07/02/18.
 */
interface LoginService {

    @POST("login/")
    fun login(@Body body: ResponseBody): Single<ServerResponse<User>>

    @POST("register/")
    fun register(@Body body: ResponseBody): Single<ServerResponse<User>>
}