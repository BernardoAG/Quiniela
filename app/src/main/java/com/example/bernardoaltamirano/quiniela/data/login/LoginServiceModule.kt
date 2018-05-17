package com.example.bernardoaltamirano.quiniela.data.login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by icaboalo on 07/02/18.
 *
 * Igual otros modulos este se encarga de regresar un objeto de tipo LoginService e injectarlo a las vistas.
 */
@Module
object LoginServiceModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }
}