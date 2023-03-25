package br.com.zup.desafirickmorth.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.domain.useCase.PersonUseCase
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonViewState
import kotlinx.coroutines.launch

<<<<<<< HEAD
class PersonViewModel(application: Application) : AndroidViewModel(application) {
=======
class PersonViewModel(private val useCase: PersonUseCase) : ViewModel() {

>>>>>>> 05d2221df9858be52e2e15e22c4669430a4f033f
    private val _personResponse = MutableLiveData<PersonViewState>()
    val personResponse: LiveData<PersonViewState> = _personResponse

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
