package br.com.zup.desafirickmorth.inject.di

import br.com.zup.desafirickmorth.domain.repository.data.datasource.remote.PersonRetrofitService
import br.com.zup.desafirickmorth.domain.repository.PersonRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"





