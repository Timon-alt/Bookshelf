package com.example.bookshelf.network

import retrofit2.http.GET

interface BooksApiService {

    @GET("programming+programming")
    suspend fun getBooksList() {
    }

    @GET()
    suspend fun getBook() {}
}