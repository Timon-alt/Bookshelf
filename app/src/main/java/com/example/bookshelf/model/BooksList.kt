package com.example.bookshelf.model

import kotlinx.serialization.Serializable

/**
 * This class defines a booksList data
 */
@Serializable
data class BooksList(
    val items: ArrayList<Book>
)
