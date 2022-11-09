package com.example.got.hilt

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.got.MainActivity
import com.example.got.network.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://thronesapi.com/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun providesCharacterService(retrofit: Retrofit): CharacterService{
        return retrofit.create(CharacterService::class.java)
    }



}
