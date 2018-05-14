package com.example.bernardoaltamirano.quiniela.data.profile

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {

    @GET("profile/{id}")
    fun getProfile(@Path("id") id: String): Single<ServerResponse<User>>
}