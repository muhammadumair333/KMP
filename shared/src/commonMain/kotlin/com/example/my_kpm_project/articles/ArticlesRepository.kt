package com.example.my_kpm_project.articles


class ArticlesRepository(private val articlesDataSource: ArticleDataSource,
    private val articlesService: ArticlesService) {

    suspend fun getArticles(forceFetch : Boolean): List<RawArticle> {

        if(forceFetch){
            articlesDataSource.clearAllArticles()
            return fetchArticlesFromNetwork()
        }

        val articlesDatabase = articlesDataSource.getArticles()
        if(articlesDatabase.isEmpty()){
            return fetchArticlesFromNetwork()
        }
        return articlesDatabase
    }

    private suspend fun fetchArticlesFromNetwork(): List<RawArticle> {
        val fetchedArticles = articlesService.getArticles()
        articlesDataSource.insertAllArticles(fetchedArticles)
        return fetchedArticles
    }

}