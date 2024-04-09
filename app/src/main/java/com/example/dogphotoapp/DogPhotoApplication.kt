package com.example.dogphotoapp
import android.app.Application
import com.example.dogphotoapp.data.AppContainer
import com.example.dogphotoapp.data.DefaultAppContainer


class DogPhotoApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}