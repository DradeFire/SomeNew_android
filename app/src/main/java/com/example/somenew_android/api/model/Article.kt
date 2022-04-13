package com.example.somenew_android.api.model

data class Article(
    val source: Source, // Источник
    val author: String, // Автор
    val content: String, // Контент
    val description: String, // Описание (начало контента)
    val publishedAt: String, // Дата создания
    val title: String, // Заголовок
    val url: String, // Ссылка на полную статью
    val urlToImage: String // Изображение
)