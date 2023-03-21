package com.wahyouwebid.core.model

import com.google.gson.annotations.SerializedName
data class BaseResponseArray<T>(
    @field:SerializedName("articles")
    val articles: List<T>,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("totalResults")
    val totalResults: Int
)