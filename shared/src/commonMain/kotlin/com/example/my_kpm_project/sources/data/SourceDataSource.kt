package com.example.my_kpm_project.sources.data

import com.example.my_kpm_project.db.MyKpmAppDatabase

class SourceDataSource(private val database : MyKpmAppDatabase) {

    fun getSources(): List<RawSource> =
        database.myKmpProjectDatabaseQueries.SelectAllSources(::mapToSourceRaw).executeAsList()


    private fun mapToSourceRaw(name : String,
                                 description : String?,
                                 language : String,
                                 country : String): RawSource = RawSource(
          name = name,
          description = description?:"",
          language = language,
          country = country
     )

    fun insertAllSources(sources: List<RawSource>) {
        database.myKmpProjectDatabaseQueries.transaction {
            sources.forEach { source ->
                insertSource(source)
            }
        }
    }

    fun clearAllSources() {
        database.myKmpProjectDatabaseQueries.DeleteAllSources()
    }

    private fun insertSource(source: RawSource) {
        database.myKmpProjectDatabaseQueries.InsertSource(
            Name = source.name,
            Description = source.description,
            Language = source.language,
            Country = source.country
        )
    }
}