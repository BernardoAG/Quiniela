package com.example.bernardoaltamirano.quiniela.data.quiniela

import com.example.bernardoaltamirano.quiniela.data.QuinielaServerResponse
import com.example.bernardoaltamirano.quiniela.data.QuinielasServerResponse
import com.example.bernardoaltamirano.quiniela.data.UsersServerResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

interface QuinielaService {

    @GET("getQuinielas/")
    fun getQuinielas(): Single<QuinielasServerResponse>

    @POST("createQuiniela/")
    fun createQuiniela(@Body requestBody: RequestBody): Single<QuinielaServerResponse>

    @GET("getQuiniela/")
    fun getQuiniela(@Query("id") id: String): Single<QuinielaServerResponse>

    @GET("getQuinielaUsers/")
    fun getMembers(@Query("id") id: String): Single<UsersServerResponse>

    @POST("sendAnswer/")
    fun sendAnswer(@Query("id") id: String, @Body body: RequestBody): Single<QuinielaServerResponse>

}