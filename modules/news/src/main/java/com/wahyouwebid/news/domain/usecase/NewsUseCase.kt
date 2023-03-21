package com.wahyouwebid.news.domain.usecase

import com.wahyouwebid.news.domain.state.NewsState

interface NewsUseCase {
    fun getNewsArticle(callback: (data: NewsState) -> Unit)
    fun getToken(): String
    fun clearDisposable()
}