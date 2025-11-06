package com.example.my_kpm_project.articles

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title : String,
    val description : String,
    val urlToImage : String,
    val publishedAt : String
)