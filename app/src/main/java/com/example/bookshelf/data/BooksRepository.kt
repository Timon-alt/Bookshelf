package com.example.bookshelf.data

import com.example.bookshelf.model.BooksList
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooksList() : List<BooksList>

    suspend fun getBook()
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {
    override suspend fun getBooksList() = booksApiService.getBooksList(
        query = ""
    )

    override suspend fun getBook() {
        TODO("Not yet implemented")
    }
}