package com.wahyouwebid.news.domain.iterator

import com.wahyouwebid.news.domain.repository.NewsRepository
import com.wahyouwebid.news.domain.state.NewsState
import com.wahyouwebid.news.domain.usecase.NewsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val repository: NewsRepository,
    private val compositeDisposable: CompositeDisposable
) : NewsUseCase {

    override fun getNewsArticle(callback: (data: NewsState) -> Unit) {
        repository.getNewsArticle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<NewsState>(NewsState::Success)
            .onErrorReturn(NewsState::Error)
            .toFlowable()
            .startWithItem(NewsState.Loading)
            .subscribe(callback)
            .let { compositeDisposable.add(it) }
    }

    override fun getToken() = repository.getToken()

    override fun clearDisposable() {
        compositeDisposable.clear()
    }
}