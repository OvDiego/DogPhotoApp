package com.example.dogphotoapp.fake

import com.example.dogphotoapp.data.NetworkDogPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class NetworkDogPhotoRepository {
    @Test
    fun networkDogPhotoRepository_getDogPhotos_verifyPhotoList(){
        runTest {
            val repository = NetworkDogPhotoRepository(
                dogApiService = FakeDogApiSerivce()
            )
            assertEquals(FakeDataSource.photoList,repository.getDogPhotos())

        }


    }
}