package com.example.dogphotoapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.thedogapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DogApiService{
    @GET("v1/images/search?limit=10")
    suspend fun getPhotos():String
}

object DogApi {
    val retrofitService: DogApiService by lazy{
        retrofit.create(DogApiService::class.java)
    }
}