package com.example.dogphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogphotoapp.model.DogPhoto
import kotlinx.coroutines.launch
import java.io.IOException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dogphotoapp.DogPhotoApplication
import com.example.dogphotoapp.data.DogPhotoRepository
import com.example.dogphotoapp.data.NetworkDogPhotoRepository
import kotlinx.coroutines.launch


//Fotos
sealed interface DogUiState{
    data class Success(val photos: List<DogPhoto>) : DogUiState
    object Error: DogUiState
    object Loading: DogUiState
}

class DogViewModel(private val dogPhotoRepository:DogPhotoRepository):ViewModel(){
    var dogUiState:DogUiState by mutableStateOf(DogUiState.Loading)
        private set

    init {
        getDogPhotos()
    }


//FOTOS
private  fun getDogPhotos(){
    viewModelScope.launch {
        dogUiState = try {
            //val listResult = DogApi.retrofitService.getPhotos()
            //val dogPhotoRepository = NetworkDogPhotoRepository()
            val listResult = dogPhotoRepository.getDogPhotos()
            DogUiState.Success(listResult)
        } catch (e: IOException){
            DogUiState.Error
        }

    }
}
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DogPhotoApplication)
                val dogPhotoRepository = application.container.dogPhotoRepository
                DogViewModel(dogPhotoRepository = dogPhotoRepository)
            }
        }
    }

}


/*IDs
sealed interface DogUiState {
    data class Success(val photoIds: List<String>): DogUiState
    object Error: DogUiState
    object Loading: DogUiState
}


    fun getDogPhotos() {
        viewModelScope.launch {
            dogUiState = try {
                val listResult = DogApi.retrofitService.getPhotos()
                val photoIds = listResult.map { it.id }
                DogUiState.Success(photoIds)
            } catch (e: IOException) {
                DogUiState.Error
            }
        }
    }
}
*/


