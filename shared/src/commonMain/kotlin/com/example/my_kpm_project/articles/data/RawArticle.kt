package com.example.my_kpm_project.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RawArticle(
    @SerialName("title")
    val title : String,
    @SerialName("description")
    val description : String?,
    @SerialName("urlToImage")
    val urlToImage : String?,
    @SerialName("publishedAt")
    val publishedAt : String
)