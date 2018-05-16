package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.data.UserServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface ProfileService {

    @GET("getUser/")
    fun getProfile(@Query("id") id: String): Single<UserServerResponse>

    @PUT("changePassword/")
    fun changePassword(@Query("id") id: String, @Body body: RequestBody): Single<UserServerResponse>
}