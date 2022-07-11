package br.com.zup.desafirickmorth.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val _personResponse = MutableLiveData<List<PersonResult>>()
    val personResponse: LiveData<List<PersonResult>> = _personResponse
    val personUseCase = PersonUseCase(application)
    fun getAllPeson() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    personUseCase.getAllPerson()
                }
                _personResponse.value = response
            } catch (ex: Exception) {
                Log.i("Error", "${ex.message}")
            }
        }
    }
}