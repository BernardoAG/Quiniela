package com.example.bernardoaltamirano.quiniela.data.profile

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
* Igual otros modulos este se encarga de regresar un objeto de tipo ProfileService e injectarlo a las vistas.
*/
@Module
object ProfileServiceModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideProfileService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }
}