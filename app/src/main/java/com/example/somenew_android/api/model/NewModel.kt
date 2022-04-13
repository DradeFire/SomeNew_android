package com.example.somenew_android.api.model

data class NewModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)