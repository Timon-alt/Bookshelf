package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookDetails
import com.example.bookshelf.model.VolumeInfo

@Composable
fun MainScreen(
    uiState: UiState,
    onRetry: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (uiState) {
        is UiState.Loading -> LoadingScreen()
        is UiState.Error -> ErrorScreen(onRetry = onRetry)
        is UiState.Success -> BooksGrid(
            books = uiState.booksList,
            contentPadding = contentPadding,
            onClick = onClick
        )
        is UiState.Description -> DetailssScreen()
    }
}

@Composable
fun LoadingScreen() {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
        modifier = Modifier.size(200.dp)
    )

}

@Composable
fun ErrorScreen(onRetry: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.connection_error),
            modifier = Modifier.size(150.dp)
        )
        Button(
            onClick = onRetry
        ) {
            Text(text = stringResource(R.string.retry_button))
        }
    }

}

@Composable
fun BooksGrid(
    books: List<BookDetails>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp),
        contentPadding = contentPadding

    ) {
        items(items = books, key = {book -> book.id}) { book ->
            BookImage(
                book.volumeInfo,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onClick }
            )
        }
    }

}

@Composable
fun BookImage(volumeInfo: VolumeInfo, modifier: Modifier = Modifier) {
    Log.d("BookImage: ", "${volumeInfo.title}")
    Card(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(volumeInfo.imageLinks?.thumbnail)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun DetailssScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {}
}