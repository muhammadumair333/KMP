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
            delay(2000L)
            _articlesState.emit(ArticlesState(error = "Something went wrong"))
            delay(2000L)
            val fetchedArticle = fetchMockedArticles()
            delay(1000L)
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }

    private fun fetchMockedArticles() : List<Article> = mockedArticles

    private val mockedArticles = listOf(
        Article(
            id = "1",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080",
            title = "First Article",
            content = "This is the content of the first article.",
            date = "2024-01-01"
        ),
        Article(
            id = "2",
            imageUrl = "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
            title = "Second Article",
            content = "This is the content of the second article.",
            date = "2024-01-02"
        ),
        Article(
            id = "3",
            imageUrl = "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
            title = "Third Article",
            content = "This is the content of the third article.",
            date = "2024-01-03"
        )
    )
}