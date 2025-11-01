package com.example.my_kpm_project.articles

import com.example.my_kpm_project.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    init {
        getArticles()
    }

    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    private fun getArticles() {
        scope.launch {
            val fetchedArticle = fetchMockedArticles()
            delay(1000L)
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }

    private fun fetchMockedArticles() : List<Article> = mockedArticles

    private val mockedArticles = listOf(
        Article(
            id = "1",
            imageUrl = "https://example.com/image1.jpg",
            title = "First Article",
            content = "This is the content of the first article.",
            date = "2024-01-01"
        ),
        Article(
            id = "2",
            imageUrl = "https://example.com/image2.jpg",
            title = "Second Article",
            content = "This is the content of the second article.",
            date = "2024-01-02"
        ),
        Article(
            id = "3",
            imageUrl = "https://example.com/image3.jpg",
            title = "Third Article",
            content = "This is the content of the third article.",
            date = "2024-01-03"
        )
    )
}