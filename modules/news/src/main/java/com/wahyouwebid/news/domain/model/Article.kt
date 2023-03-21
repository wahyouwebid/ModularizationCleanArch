package com.wahyouwebid.news.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep
@Parcelize
@Keep
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val title: String?,
    val urlToImage: String?
): Parcelable