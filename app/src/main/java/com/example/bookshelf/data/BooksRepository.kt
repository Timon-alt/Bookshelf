package com.example.bookshelf.data

import com.example.bookshelf.model.BooksList
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooksList() : BooksList

    suspend fun getBook()
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {
    override suspend fun getBooksList() : BooksList = booksApiService.getBooksList(
        query = "jazz+history"
    )

    override suspend fun getBook() {
        TODO("Not yet implemented")
    }
}