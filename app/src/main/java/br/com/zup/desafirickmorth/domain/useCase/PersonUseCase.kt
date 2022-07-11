package br.com.zup.desafirickmorth.domain.useCase

import android.app.Application
import br.com.zup.desafirickmorth.data.datasource.local.database.PersonDataBase
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.repository.PersonRepository
import br.com.zup.desafirickmorth.ui.viewstate.ViewState

class PersonUseCase(application: Application) {
    val personDao = PersonDataBase.getDatabase(application).personDao()
    val repository = PersonRepository(personDao)
    suspend fun getAllPersonDao(): ViewState<List<PersonResult>> {
        return try {
            val persons = repository.getAllPersonDao()
            ViewState.Success(persons)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possivel carregar os personagens"))
        }
    }
}