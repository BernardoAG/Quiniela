package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.data.ServerResponse
import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

interface QuinielaService {

    @GET("quinielas/")
    fun getQuinielas(): Single<ServerResponse<List<Quiniela>>>

    @POST("quinielas/new/")
    fun createQuiniela(@Body requestBody: RequestBody): Single<ServerResponse<Quiniela>>

    @GET("quiniela/")
    fun getQuiniela(@Query("id") id: Long): Single<ServerResponse<Quiniela>>

    @GET("quiniela/members/")
    fun getMembers(@Query("id") id: Long): Single<ServerResponse<List<User>>>

}