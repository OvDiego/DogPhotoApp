package com.example.dogphotoapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogphotoapp.R
import com.example.dogphotoapp.viewmodel.DogUiState

@Composable

fun HomeScreen(
    dogUiState:DogUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(dogUiState){
        is DogUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is DogUiState.Success -> ResultScreen(photos = dogUiState.photos, modifier = modifier.fillMaxWidth())
        is DogUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }

}



@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
        ){
        Image(painter = painterResource(id = R.drawable.loader), 
            contentDescription = "Loading" )
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Error")

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
       // HomeScreen(stringResource(R.string.placeholder_result))
    }

}