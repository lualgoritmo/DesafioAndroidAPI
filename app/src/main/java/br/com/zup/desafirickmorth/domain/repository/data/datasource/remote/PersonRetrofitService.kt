package br.com.zup.desafirickmorth.domain.repository.data.datasource.remote

import br.com.zup.desafirickmorth.domain.repository.data.model.RickAndMortyResponse
import retrofit2.http.GET

interface PersonRetrofitService {
    @GET("character")
    suspend fun getAllPerson(): RickAndMortyResponse
}
