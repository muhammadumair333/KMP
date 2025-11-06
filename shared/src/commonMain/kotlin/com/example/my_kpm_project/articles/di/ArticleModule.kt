package com.example.my_kpm_project.articles.di

import com.example.my_kpm_project.articles.data.ArticleDataSource
import com.example.my_kpm_project.articles.data.ArticlesRepository
import com.example.my_kpm_project.articles.data.ArticlesService
import com.example.my_kpm_project.articles.application.ArticlesUseCase
import com.example.my_kpm_project.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticleDataSource> { ArticleDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}