package com.example.my_kpm_project.articles

class ArticlesUseCase(private val articlesService: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        val articlesRaw = articlesService.getArticles()
        return mapArticle(articlesRaw)
    }


    private fun mapArticle(rawResponse: List<RawArticle>): List<Article> {
        return rawResponse.map { rawArticle ->
            Article(
                title = rawArticle.title,
                description = rawArticle.description ?: "Click to add more details",
                urlToImage = rawArticle.urlToImage ?: "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
                publishedAt = rawArticle.publishedAt,
                content = rawArticle.content ?: "No content available"
            )
        }
    }
}