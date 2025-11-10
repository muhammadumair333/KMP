package com.example.my_kpm_project.articles.presentation

import com.example.my_kpm_project.articles.application.Article
import com.example.my_kpm_project.articles.application.ArticlesUseCase
import com.example.my_kpm_project.base.BaseViewModel
import com.example.my_kpm_project.base.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val useCase: ArticlesUseCase) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<UIState<List<Article>>> =
        MutableStateFlow(UIState(isLoading = true))
    val articlesState: StateFlow<UIState<List<Article>>>
        get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.value = UIState(isLoading = true)
            val fetchedArticles = useCase.getArticles(forceFetch)
            _articlesState.value = UIState(result = fetchedArticles, isLoading = false)
        }
    }
}