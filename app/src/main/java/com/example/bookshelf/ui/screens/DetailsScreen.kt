package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.request.ImageRequest
import coil3.compose.AsyncImage
import com.example.bookshelf.R

@Composable
fun DetailsScreen(
    imageBook: String,
    title: String,
    description: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageBook)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.image_description),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}