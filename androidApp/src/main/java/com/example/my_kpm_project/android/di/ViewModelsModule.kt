package com.example.my_kpm_project.android.di

import com.example.my_kpm_project.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ArticlesViewModel(get())
    }
}