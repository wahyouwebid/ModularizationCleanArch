package com.wahyouwebid.news.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyouwebid.news.domain.state.NewsState
import com.wahyouwebid.news.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val useCase: NewsUseCase,
) : ViewModel() {
    val article: MutableLiveData<NewsState> by lazy {
        MutableLiveData()
    }

    fun getNewsArticles() {
        useCase.getNewsArticle { article.postValue(it) }
    }

    override fun onCleared() {
        super.onCleared()
        useCase.clearDisposable()
    }
}