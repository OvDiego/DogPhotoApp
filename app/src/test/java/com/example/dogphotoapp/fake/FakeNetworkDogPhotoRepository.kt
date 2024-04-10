package com.example.dogphotoapp.fake

import com.example.dogphotoapp.data.DogPhotoRepository
import com.example.dogphotoapp.model.DogPhoto

class FakeNetworkDogPhotoRepository:DogPhotoRepository {
    override suspend fun getDogPhotos(): List<DogPhoto> {
        return FakeDataSource.photoList
    }

}