package com.example.my_kpm_project.sources.data

import com.example.my_kpm_project.base.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class SourcesService(private val httpClient: HttpClient) {
    suspend fun getSources(): List<RawSource> {
        val response : SourcesResponse = httpClient.get(Constants.BASE_URL + Constants.SOURCES_ENDPOINT) {
            parameter("apiKey", Constants.API_KEY)
        }.body<SourcesResponse>()

        return response.sources
    }
}