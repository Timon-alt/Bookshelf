package com.example.bookshelf.network

import retrofit2.http.GET

interface BooksApiService {

    @GET("volumes?q=jazz+history")
    suspend fun getBooksList() {
    }

    @GET()
    suspend fun getBook() {}
}