package com.example.my_kpm_project.articles.di

import com.example.my_kpm_project.articles.ArticlesService
import com.example.my_kpm_project.articles.ArticlesUseCase
import com.example.my_kpm_project.articles.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
}