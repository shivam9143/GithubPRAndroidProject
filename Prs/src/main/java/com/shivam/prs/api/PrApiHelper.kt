package com.shivam.prs.api

import javax.inject.Inject

class PrApiHelper @Inject constructor(val prApi: PrApi) {

    suspend fun getGithubPrs(page : Int) =
        prApi.getGithubPrs(page = page)

}