package com.example.bookshelf.model.bookDescription

data class BookDetails(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val description: String
)
