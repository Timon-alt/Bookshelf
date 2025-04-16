package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookDetails
import com.example.bookshelf.model.BooksList
import com.example.bookshelf.network.BooksApiService

/**
 * Repository that fetches books list from GoogleApi
 */
interface BooksRepository {
    suspend fun getBooksList(query: String) : BooksList

    suspend fun getBook(id: String) : BookDetails
}

/**
 * Network implementation of Repository that fetch books list from GoogleApi
 */
class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {

    override suspend fun getBooksList(query: String): BooksList =
        booksApiService.getBooksList(query)

    override suspend fun getBook(id: String) : BookDetails =
        booksApiService.getBook(id)
}