package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookImage(
    var thumbnail : String? = null
)


