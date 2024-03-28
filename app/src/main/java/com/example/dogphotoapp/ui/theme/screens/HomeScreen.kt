package com.example.dogphotoapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dogphotoapp.R
import com.example.dogphotoapp.model.DogPhoto
import com.example.dogphotoapp.viewmodel.DogUiState





 //DESPLIEGUE HORIZONTAL
@Composable
fun HomeScreen(
    dogUiState: DogUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (dogUiState) {
        is DogUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is DogUiState.Success -> {
            LazyRow(
                modifier = modifier.fillMaxSize(),
                contentPadding = contentPadding
            ) {
                items(dogUiState.photos) { photo ->
                    DogPhotoCard(photo = photo, modifier = Modifier.padding(4.dp))
                }
            }
        }
        is DogUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }
}

//DESPLIEJE VERTICAL
/*@Composable

fun HomeScreen(
    dogUiState:DogUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(dogUiState){
        is DogUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is DogUiState.Success -> PhotosGridScreen(photos = dogUiState.photos, modifier = modifier.fillMaxWidth())
        is DogUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }

}*/

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
fun ErrorScreen(modifier: Modifier= Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Problemas de conexión")
        Text(text = stringResource(id = R.string.problem_with_connection))
    }
}


@Composable
fun DogPhotoCard(photo: DogPhoto, modifier: Modifier){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp), // Bordes redondos
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier.aspectRatio(1.5f)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(photo.url)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.dog_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(8.dp)), // clip
                error = painterResource(id = R.drawable.error_404),
                placeholder = painterResource(id = R.drawable.carga)
            )
        }
    }
}

@Composable
fun PhotosGridScreen(
    photos : List<DogPhoto>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(250.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ){
        items (
            items = photos,
            key = { photo -> photo.id}
        ){
            photo -> DogPhotoCard(photo = photo,
            modifier = modifier
                .padding(4.dp)
                .fillMaxSize()
                .aspectRatio(1.5f)
            )
        }
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