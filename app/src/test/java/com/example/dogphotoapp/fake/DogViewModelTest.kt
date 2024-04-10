package com.example.dogphotoapp.fake

import com.example.dogphotoapp.fake.rules.TestDispatcherRule
import com.example.dogphotoapp.viewmodel.DogUiState
import com.example.dogphotoapp.viewmodel.DogViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class DogViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
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