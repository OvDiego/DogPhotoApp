package com.example.dogphotoapp.fake

import com.example.dogphotoapp.viewmodel.DogUiState
import com.example.dogphotoapp.viewmodel.DogViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class DogViewModelTest {
    @Test
    fun dogViewModel_getDogPhotos_verifyDogUiStateSuccess(){
        runTest {
            val dogViewModel = DogViewModel(
                dogPhotoRepository = FakeNetworkDogPhotoRepository()
            )
            assertEquals(DogUiState.Success(FakeDataSource.photoList),dogViewModel.dogUiState)
        }
    }
}