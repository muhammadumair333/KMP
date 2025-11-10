package com.example.my_kpm_project.di

import com.example.my_kpm_project.articles.di.articleModule
import com.example.my_kpm_project.sources.di.sourceModule

val sharedKoinModules = listOf(
    netWorkModule,
    articleModule,
    sourceModule
)