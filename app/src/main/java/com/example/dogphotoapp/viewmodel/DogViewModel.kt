package com.example.dogphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogphotoapp.network.DogApi
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface DogUiState{
    data class Success(val photos:String) : DogUiState
    object Error: DogUiState
    object Loading: DogUiState
}


class DogViewModel: ViewModel() {
    var dogUiState:DogUiState by mutableStateOf(DogUiState.Loading)
        private set

    init {
        getDogPhotos()
    }

    fun getDogPhotos(){
        viewModelScope.launch {
          dogUiState =  try {
            val listResult = DogApi.retrofitService.getPhotos()
            DogUiState.Success(listResult)
            }
            catch (e:IOException){
                DogUiState.Error
            }
        }
    }
}