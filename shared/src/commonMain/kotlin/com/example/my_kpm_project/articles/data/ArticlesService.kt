package com.example.my_kpm_project.articles.data

import com.example.my_kpm_project.base.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArticlesService(private val httpClient: HttpClient) {

    suspend fun getArticles(): List<RawArticle> {
        val response : ArticlesResponse = httpClient.get(Constants.BASE_URL + Constants.HEADLINES_ENDPOINT) {
            parameter("country", Constants.COUNTRY)
            parameter("category", Constants.CATEGORY)
            parameter("apiKey", Constants.API_KEY)
        }.body<ArticlesResponse>()

        return response.articles
    }
}