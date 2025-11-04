package com.example.my_kpm_project.di

import com.example.my_kpm_project.articles.di.articleModule

val sharedKoinModules = listOf(
    netWorkModule,
    articleModule
)