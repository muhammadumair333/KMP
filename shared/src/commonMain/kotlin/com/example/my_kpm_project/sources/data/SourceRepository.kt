package com.example.my_kpm_project.sources.data

class SourceRepository(private val dataSource: SourceDataSource,
    private val sourcesService: SourcesService) {

    suspend fun getSources(): List<RawSource> {
        val localSources = dataSource.getSources()
        if(localSources.isEmpty())
        {
            return getSourcesFromNetwork()
        }
         return sourcesService.getSources()
    }

    suspend fun getSourcesFromNetwork(): List<RawSource> {
        val fetchedSources = sourcesService.getSources()
        dataSource.insertAllSources(fetchedSources)
        return fetchedSources
    }

}