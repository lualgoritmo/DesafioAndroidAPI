package br.com.zup.desafirickmorth.domain.repository

import br.com.zup.desafirickmorth.data.datasource.local.dao.PersonDao
import br.com.zup.desafirickmorth.data.model.PersonResult

class PersonRepository(private val personDao: PersonDao) {
    suspend fun insertPersonDao(personList: List<PersonResult>) {
        personDao.insertPersonDao(personList)
    }

    suspend fun getAllPersonDao(): List<PersonResult> = personDao.getAllPersonDao()
}