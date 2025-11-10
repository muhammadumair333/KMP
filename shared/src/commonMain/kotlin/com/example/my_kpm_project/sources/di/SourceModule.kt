package com.example.my_kpm_project.sources.di

import com.example.my_kpm_project.sources.data.SourceRepository
import com.example.my_kpm_project.sources.application.SourceUseCase
import com.example.my_kpm_project.sources.data.SourceDataSource
import com.example.my_kpm_project.sources.data.SourcesService
import org.koin.dsl.module

val sourceModule = module {
   single<SourceDataSource> { SourceDataSource(get()) }
   single<SourcesService> { SourcesService(get()) }
   single<SourceRepository>{ SourceRepository(get(), get()) }
   single<SourceUseCase> { SourceUseCase(get()) }
}