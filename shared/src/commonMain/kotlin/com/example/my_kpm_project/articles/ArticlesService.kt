package com.example.my_kpm_project.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "technology"
    private val apiKey = "e8c0e77837ae4c87a1c43eb8318f1659"

    suspend fun getArticles(): List<RawArticle> {
        val response : ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines") {
            parameter("country", country)
            parameter("category", category)
            parameter("apiKey", apiKey)
        }.body<ArticlesResponse>()

        return response.articles
    }
}