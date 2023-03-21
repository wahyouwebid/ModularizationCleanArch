package com.wahyouwebid.news.data.network

import com.wahyouwebid.core.Constants
import com.wahyouwebid.core.model.BaseResponseArray
import com.wahyouwebid.news.data.model.ArticleItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getNewsArticles(
        @Query("country") country:String = Constants.COUNTRY,
        @Query("category") category: String= Constants.CATEGORY,
        @Query("apiKey") apiKey:String = Constants.API_KEY
    ): Single<BaseResponseArray<ArticleItem>>

}