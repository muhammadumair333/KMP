package com.example.my_kpm_project.articles

import io.ktor.util.logging.Logger

class ArticlesRepository(private val articlesDataSource: ArticleDataSource,
    private val articlesService: ArticlesService) {

    suspend fun getArticles(): List<RawArticle> {
        val articlesDatabase = articlesDataSource.getArticles()
        println("Articles in DB: ${articlesDatabase.size}")
        if(articlesDatabase.isEmpty()){
            val fetchedArticles = articlesService.getArticles()
            articlesDataSource.insertAllArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDatabase
    }

}