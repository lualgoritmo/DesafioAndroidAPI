package br.com.zup.desafirickmorth.domain.repository

import br.com.zup.desafirickmorth.data.datasource.local.dao.PersonDao
import br.com.zup.desafirickmorth.data.datasource.remote.RetrofitService
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.data.model.RickAndMortyResponse

class PersonRepository(private val personDao: PersonDao) {
    suspend fun insertPersonDao(personList: List<PersonResult>) {
        personDao.insertPersonDao(personList)
    }
    suspend fun getAllPerson(): RickAndMortyResponse {
        return RetrofitService.apiService.getAllPerson()
    }
    suspend fun getAllPersonDao(): List<PersonResult> = personDao.getAllPersonDao()
}