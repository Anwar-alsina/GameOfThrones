package com.example.got.network

import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {
    @GET("Characters")
    suspend fun getAllCharacters(): Response<List<NetworkCharacters>>
}