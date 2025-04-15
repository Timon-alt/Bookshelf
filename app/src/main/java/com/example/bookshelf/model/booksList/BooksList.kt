package com.example.bookshelf.model.booksList

import kotlinx.serialization.Serializable

/**
 * This class defines a booksList data
 */
@Serializable
data class BooksList(
    val items: List<Book>
)
