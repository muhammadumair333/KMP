package com.example.my_kpm_project.articles.presentation

import com.example.my_kpm_project.articles.application.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null)
