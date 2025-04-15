package com.example.bookshelf.data

import com.example.bookshelf.model.bookDescription.Book
import com.example.bookshelf.model.booksList.BooksList
import com.example.bookshelf.network.BooksApiService

/**
 * Repository that fetches books list from GoogleApi
 */
interface BooksRepository {
    suspend fun getBooksList(query: String) : BooksList

    suspend fun getBook(id: String) : Book
}

/**
 * Network implementation of Repository that fetch books list from GoogleApi
 */
class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {

    override suspend fun getBooksList(query: String): BooksList =
        booksApiService.getBooksList(query)

    override suspend fun getBook(id: String) : Book = booksApiService.getBook(id)
}