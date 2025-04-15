package com.example.bookshelf.model.booksList

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val volumeInfo: BookInfo
)
