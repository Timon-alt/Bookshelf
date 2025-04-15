package com.example.bookshelf.network

import com.example.bookshelf.model.BookInfo
import com.example.bookshelf.model.BooksList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun getBooksList(
        @Query("q") query: String
    ): BooksList

    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") id: String
    ): BookInfo
}