package com.example.dogphotoapp.network

import com.example.dogphotoapp.model.DogPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.thedogapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface DogApiService{
    @GET("v1/images/search?limit=20&api_key=live_uQdeKriLiSgoEBIP3MOB3vVqMXAp17c4KSCeFxBl0sK7z8UWiNBn0qgTrFRiRhA7")
    suspend fun getPhotos():List<DogPhoto>
}

object DogApi {
    val retrofitService: DogApiService by lazy{
        retrofit.create(DogApiService::class.java)
    }
}