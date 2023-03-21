package com.wahyouwebid.news.data.model

import com.google.gson.annotations.SerializedName
import com.wahyouwebid.news.domain.model.Article

data class ArticleItem(
    @field:SerializedName("author")
    val author: String?,
    @field:SerializedName("content")
    val content: String?,
    @field:SerializedName("description")
    val description: String?,
    @field:SerializedName("publishedAt")
    val publishedAt: String?,
    @field:SerializedName("source")
    val source: SourceItem?,
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("url")
    val url: String?,
    @field:SerializedName("urlToImage")
    val urlToImage: String?
){
    fun toArticle(): Article {
        return Article(
            author = this.author?:"",
            content = this.content?:"",
            description = this.description?:"",
            title = this.title?:"",
            urlToImage = this.urlToImage?:""
        )
    }
}