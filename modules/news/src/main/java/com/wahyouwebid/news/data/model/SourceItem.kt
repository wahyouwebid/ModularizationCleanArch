package com.wahyouwebid.news.data.model

import com.google.gson.annotations.SerializedName

data class SourceItem(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("name")
    val name: String
)