package com.example.my_kpm_project.articles

import com.example.my_kpm_project.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(isLoading = true))
    private val useCase : ArticlesUseCase

    init {
        val httpClient = HttpClient{
            install(ContentNegotiation){
                json(Json{
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticlesService(httpClient)
        useCase = ArticlesUseCase(service)
        getArticles()
    }

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    private fun getArticles() {
        scope.launch {
            val fetchedArticle = useCase.getArticles()
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }
}