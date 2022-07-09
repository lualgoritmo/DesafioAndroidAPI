package br.com.zup.desafirickmorth.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyAPI {
    @GET("https://rickandmortyapi.com/api/character")
    suspend fun getAllPersona(
        @Query("name")
        name: String?,
        @Query("status")
        status: String?,
        @Query("species")
        species: String?,
        @Query("gender")
        gender: String
    )
    //ESTÁ ESTENDO: DE ALGO VER DEPOIS
}