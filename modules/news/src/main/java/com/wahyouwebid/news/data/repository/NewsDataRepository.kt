package com.wahyouwebid.news.data.repository

import com.wahyouwebid.core.database.Sessions
import com.wahyouwebid.news.data.network.NewsApiService
import com.wahyouwebid.news.domain.model.Article
import com.wahyouwebid.news.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single

class NewsDataRepository(
    private val apiService: NewsApiService,
    private val sessions: Sessions
) : NewsRepository {

    override fun getNewsArticle(): Single<List<Article>> {
        return apiService.getNewsArticles().map { it.articles.map { data -> data.toArticle() } }
    }

    override fun getToken() = sessions.getString(Sessions.token)

}