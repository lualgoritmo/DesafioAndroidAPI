package br.com.zup.desafirickmorth.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.desafirickmorth.data.datasource.remote.RetrofitService
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.data.model.RickAndMortyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel : ViewModel() {
    private val _personResponse = MutableLiveData<List<PersonResult>>()
    val personResponse: LiveData<List<PersonResult>> = _personResponse

    fun getAllPeson() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitService.apiService.getAllPerson()
                }
                _personResponse.value = response.results
            } catch (ex: Exception) {
                Log.i("Error", "${ex.message}")
            }
        }
    }
}