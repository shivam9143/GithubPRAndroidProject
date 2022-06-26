package com.shivam.prs.api

import com.shivam.prs.models.PrResponseModel
import com.shivam.prs.models.PullRequest
import retrofit2.http.GET
import retrofit2.http.Query

interface PrApi {
    @GET("shivam9143/GithubPRAndroidProject/pulls")
    suspend fun getGithubPrs(
        @Query("state") state: String = "closed",
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = 10
    ): List<PullRequest>
}