package com.example.my_kpm_project.articles.presentation

import com.example.my_kpm_project.BaseViewModel
import com.example.my_kpm_project.articles.application.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val useCase: ArticlesUseCase) : BaseViewModel() {

    private val _articlesState : MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(isLoading = true))

    init {
        getArticles()
    }

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    fun getArticles(forceFetch : Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesState(isLoading = true,
                articles = articlesState.value.articles)
            )
            val fetchedArticle = useCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }
}