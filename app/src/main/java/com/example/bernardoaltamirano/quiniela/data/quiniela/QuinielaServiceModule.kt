package com.example.bernardoaltamirano.quiniela.data.quiniela

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Igual otros modulos este se encarga de regresar un objeto de tipo QuinielaService e injectarlo a las vistas.
 */
@Module
object QuinielaServiceModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideQuinielaService(retrofit: Retrofit): QuinielaService {
        return retrofit.create(QuinielaService::class.java)
    }
}