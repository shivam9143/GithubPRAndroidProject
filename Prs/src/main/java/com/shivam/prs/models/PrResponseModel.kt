package com.shivam.prs.models

import com.google.gson.annotations.SerializedName

data class PrResponseModel(val data: List<PullRequest>)

data class PullRequest(
    @SerializedName("title")
    val title: String?,
    @SerializedName("created_at")
    val created_date: String?,
    @SerializedName("closed_at")
    val closed_date: String?,
    val user: User
)

data class User(
    @SerializedName("login")
    val name: String,
    @SerializedName("avatar_url")
    val avatar_url: String?
)