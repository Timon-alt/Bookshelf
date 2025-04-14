package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooksList()

    suspend fun getBook()
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {
    override suspend fun getBooksList() {
        TODO("Not yet implemented")
    }

    override suspend fun getBook() {
        TODO("Not yet implemented")
    }
}