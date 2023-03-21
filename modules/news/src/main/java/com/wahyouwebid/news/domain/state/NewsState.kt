package com.wahyouwebid.news.domain.state

import com.wahyouwebid.news.domain.model.Article

sealed class NewsState {
    object Loading : NewsState()

    data class Success(val data: List<Article>) : NewsState()

    data class Error(val error: Throwable) : NewsState()
}