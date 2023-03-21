package com.wahyouwebid.news.di

import com.wahyouwebid.core.database.Sessions
import com.wahyouwebid.news.data.network.NewsApiService
import com.wahyouwebid.news.data.repository.NewsDataRepository
import com.wahyouwebid.news.domain.iterator.NewsIterator
import com.wahyouwebid.news.domain.usecase.NewsUseCase
import com.wahyouwebid.news.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NewsModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(
        newsApiService: NewsApiService,
        sessions: Sessions
    ): NewsRepository {
        return NewsDataRepository(newsApiService, sessions)
    }

    @Provides
    fun provideGetNewsUseCase(
        newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): NewsUseCase {
        return NewsIterator(newsRepository, compositeDisposable)
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

}