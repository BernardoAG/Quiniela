package com.example.bernardoaltamirano.quiniela.database

import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
object DatabaseModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }
}