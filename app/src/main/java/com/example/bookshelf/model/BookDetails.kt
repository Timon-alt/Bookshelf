package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookDetails(
    val id: String,
    val volumeInfo: VolumeInfo
)
