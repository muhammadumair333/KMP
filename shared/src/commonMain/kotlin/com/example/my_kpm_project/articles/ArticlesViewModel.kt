package com.example.my_kpm_project.articles

import com.example.my_kpm_project.BaseViewModel
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

    private fun getArticles() {
        scope.launch {
            val fetchedArticle = useCase.getArticles()
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }
}