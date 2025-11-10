package com.example.my_kpm_project.articles.data

import com.example.my_kpm_project.db.MyKpmAppDatabase

class ArticleDataSource(private val database : MyKpmAppDatabase) {

    fun getArticles(): List<RawArticle> =
        database.myKmpProjectDatabaseQueries.SelectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertAllArticles(articles: List<RawArticle>) {
        database.myKmpProjectDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearAllArticles() {
        database.myKmpProjectDatabaseQueries.DeleteAllArticles()
    }

    private fun mapToArticleRaw(
        title: String,
        description: String?,
        publishedAt: String,
        urlToImage: String?,
    ): RawArticle = RawArticle(
        title = title,
        description = description,
        publishedAt= publishedAt,
        urlToImage = urlToImage
    )

    private fun insertArticle(article: RawArticle) {
        database.myKmpProjectDatabaseQueries.InsertArticle(
            Title = article.title,
            Description = article.description,
            PublishedAt = article.publishedAt,
            ImageUrl = article.urlToImage
        )
    }

}