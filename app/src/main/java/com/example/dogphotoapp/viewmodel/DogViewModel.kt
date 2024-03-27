package com.example.dogphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogphotoapp.network.DogApi
import kotlinx.coroutines.launch

class DogViewModel: ViewModel() {
    var dogUiState by mutableStateOf("")
        private set

    init {
        getDogPhotos()
    }

    fun getDogPhotos(){
        viewModelScope.launch {
            val listResult = DogApi.retrofitService.getPhotos()
            dogUiState=listResult
        }
    }
}