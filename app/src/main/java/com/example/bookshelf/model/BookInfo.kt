package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookInfo(
    val title: String,
    val subtitle: String,
    val authors: ArrayList<String>,
    val publishedDate: String,
    val pageCount: Int,
    val imageList: ArrayList<String>,
    val description: String
)
