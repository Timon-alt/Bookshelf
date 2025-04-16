package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String,
    val subtitle: String? = null,
    val imageLinks: BookImage? = null,
    val authors: List<String>? = null,
    val description: String? = null
)
