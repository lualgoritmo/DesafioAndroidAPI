package br.com.zup.desafirickmorth.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonViewState
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val _personResponse = MutableLiveData<PersonViewState>()
    val personResponse: LiveData<PersonViewState> = _personResponse
    private val useCase = PersonUseCase(application)

    fun getAllPeson() {
        viewModelScope.launch {
            _personResponse.value = PersonViewState.Loading
            try {
                 val response = useCase.getAllPerson()
                _personResponse.value = PersonViewState.Success(response)
            } catch (ex: Exception) {
                _personResponse.value = PersonViewState.Error(ex.message ?: "Erro aqui")
            }
        }
    }
}
