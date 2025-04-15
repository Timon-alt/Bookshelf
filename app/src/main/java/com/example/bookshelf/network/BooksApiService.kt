package com.example.bookshelf.network

import com.example.bookshelf.model.bookDescription.Book
import com.example.bookshelf.model.booksList.BookInfo
import com.example.bookshelf.model.booksList.BooksList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * A public interface that exposes the [getBooksList], [getBook] methods
 */
interface BooksApiService {

    /**
     *
     */
    @GET("volumes")
    suspend fun getBooksList(
        @Query("q") query: String
    ): BooksList

    /**
     *
     */
    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") id: String
    ): Book
}