package br.com.zup.desafirickmorth.domain.useCase

import android.app.Application
import br.com.zup.desafirickmorth.data.datasource.local.database.PersonDataBase
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.repository.PersonRepository

class PersonUseCase(application: Application) {
    val personDao = PersonDataBase.getDatabase(application).personDao()
    val repository = PersonRepository(personDao)

    suspend fun getAllPersonDao(): List<PersonResult> {
        return repository.getAllPersonDao()
    }

    suspend fun getAllPerson(): List<PersonResult> {
        return try {
            val person = repository.getAllPerson()
            repository.insertPersonDao(person.results)
            getAllPersonDao()
        } catch (ex: Exception) {
            return getAllPersonDao()
        }
    }
}