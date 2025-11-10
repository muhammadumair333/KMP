package com.example.my_kpm_project.sources.application

import com.example.my_kpm_project.sources.data.RawSource
import com.example.my_kpm_project.sources.data.SourceRepository

class SourceUseCase(private val sourceRepository: SourceRepository) {

    suspend fun getSources(): List<Source> {
        val sources = sourceRepository.getSources()
        return mapSource(sources)
    }

    private fun mapSource(rawSources: List<RawSource>): List<Source> {
        return rawSources.map {  rawSource ->
            Source(
                name = rawSource.name,
                description = rawSource.description,
                language = rawSource.language,
                country = rawSource.country
            )
        }
    }

}