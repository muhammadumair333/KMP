package com.example.my_kpm_project.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val articlesRepository: ArticlesRepository) {

    suspend fun getArticles(): List<Article> {
        val articlesRaw = articlesRepository.getArticles()
        return mapArticle(articlesRaw)
    }


    private fun mapArticle(rawResponse: List<RawArticle>): List<Article> {
        return rawResponse.map { rawArticle ->
            Article(
                title = rawArticle.title,
                description = rawArticle.description ?: "Click to add more details",
                urlToImage = rawArticle.urlToImage ?: "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
                publishedAt = publishedDateFromToday(rawArticle.publishedAt)
            )
        }
    }

    private fun publishedDateFromToday(dateString: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(dateString).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )
        return when {
            abs(days) > 1 -> "${abs(days)} days ago"
            days == 1 -> "Yesterday"
            else -> "Today"
        }

    }
}