package br.com.zup.desafirickmorth.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.data.datasource.local.database.PersonDataBase
import br.com.zup.desafirickmorth.data.datasource.remote.RetrofitService
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val _personResponse = MutableLiveData<List<PersonResult>>()
    val personResponse: LiveData<List<PersonResult>> = _personResponse
    val personDao = PersonDataBase.getDatabase(application).personDao()
    val repository = PersonRepository(personDao)
    fun getAllPeson() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitService.apiService.getAllPerson()
                }
                repository.insertPersonDao(response.results)
                val personListDao = repository.getAllPersonDao()
                _personResponse.value = personListDao
            } catch (ex: Exception) {
                Log.i("Error", "${ex.message}")
            }
        }
    }
}