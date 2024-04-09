package com.example.dogphotoapp.fake

import com.example.dogphotoapp.model.DogPhoto


object FakeDataSource{
    const val idOne = "idDog1"
    const val idTwo = "idDog2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    const val widthOne = 225
    const val heigtOne = 225
    const val widthTwo = 125
    const val heightTwo = 125


    val photoList = listOf(
        DogPhoto(
            idOne,
            imgOne,
            widthOne,
            heightTwo
        ),
        DogPhoto(idTwo,
            imgTwo,
            widthTwo,
            heightTwo)
    )
}