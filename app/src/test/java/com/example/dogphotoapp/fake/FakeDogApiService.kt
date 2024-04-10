package com.example.dogphotoapp.fake

import com.example.dogphotoapp.model.DogPhoto
import com.example.dogphotoapp.network.DogApiService

class FakeDogApiService:DogApiService {
    override suspend fun getPhotos(): List<DogPhoto> {
        return FakeDataSource.photoList
    }
}