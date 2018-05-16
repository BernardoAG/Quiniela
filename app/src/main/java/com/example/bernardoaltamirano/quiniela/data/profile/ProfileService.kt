package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.data.UserServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {

    @GET("getUser/")
    fun getProfile(@Query("id") id: String): Single<UserServerResponse>
}