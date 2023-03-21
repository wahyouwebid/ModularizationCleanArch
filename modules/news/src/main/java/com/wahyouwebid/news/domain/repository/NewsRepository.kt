package com.wahyouwebid.news.domain.repository

import com.wahyouwebid.news.domain.model.Article
import io.reactivex.rxjava3.core.Single

interface NewsRepository {

    fun getNewsArticle(): Single<List<Article>>

    fun getToken(): String

}