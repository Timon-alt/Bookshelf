package com.example.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.BooksList
import kotlinx.coroutines.launch
import okio.IOException

sealed interface UiState {
    data class Success(val booksList: List<BooksList>) : UiState
    object Error : UiState
    object Loading : UiState
}

class BookshelfViewModel(private val booksRepository: BooksRepository) : ViewModel() {

    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getBooksList()
    }

    fun getBooksList() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(booksRepository.getBooksList())
            } catch (e: IOException) {
                UiState.Error
            } catch (e: HttpException) {
                UiState.Error
            }
        }
    }

    fun getBook() {

    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val booksRepository = application.container.booksRepository
                BookshelfViewModel(booksRepository = booksRepository)
            }
        }
    }
}