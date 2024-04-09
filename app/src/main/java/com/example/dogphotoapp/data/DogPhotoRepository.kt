package com.example.dogphotoapp.data

import com.example.dogphotoapp.model.DogPhoto
//import com.example.dogphotoapp.network.DogApi
import com.example.dogphotoapp.network.DogApiService


interface DogPhotoRepository{
    suspend fun getDogPhotos():List<DogPhoto>
}

class NetworkDogPhotoRepository(
    private val dogApiService: DogApiService
): DogPhotoRepository{
    override suspend fun getDogPhotos(): List<DogPhoto> = dogApiService.getPhotos()
}