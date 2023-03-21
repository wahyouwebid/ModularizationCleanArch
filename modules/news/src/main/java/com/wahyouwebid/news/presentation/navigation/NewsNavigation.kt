package com.wahyouwebid.news.presentation.navigation

import com.wahyouwebid.news.domain.model.Article

interface NewsNavigation {
    fun goToPrevious()

    fun fromNewsListToNewsDetail(article: Article)
}