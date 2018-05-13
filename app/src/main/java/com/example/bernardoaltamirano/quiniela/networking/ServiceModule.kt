package com.example.bernardoaltamirano.quiniela.networking

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by icaboalo on 07/02/18.
 */

@Module(includes = [
    NetworkingModule::class
])
object ServiceModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())

                .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, callFactory: Call.Factory,
                        @Named("base_url") baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideFirebaseDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference.child("México")
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideFirebaseStorageReference(): StorageReference {
        return FirebaseStorage.getInstance().reference
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}