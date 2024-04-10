package com.example.dogphotoapp.fake

import com.example.dogphotoapp.model.DogPhoto

object FakeDataSource2 {
    const val idThree = "idDog3"
    const val idFour = "idDog4"
    const val imgThree = "url.3"
    const val imgFour = "url.4"
    const val widthThree = 300
    const val heightThree = 300
    const val widthFour = 150
    const val heightFour = 150

    val photoList = listOf(
        DogPhoto(
            idThree,
            imgThree,
            widthThree,
            heightThree
        ),
        DogPhoto(
            idFour,
            imgFour,
            widthFour,
            heightFour
        )
    )
}
