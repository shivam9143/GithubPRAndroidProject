package com.shivam.prs.repository

import com.shivam.base.repository.BaseRepository
import com.shivam.prs.api.PrApiHelper
import javax.inject.Inject

class PrRepository @Inject constructor(val prApiHelper: PrApiHelper) : BaseRepository() {

    suspend fun getPr(page : Int) =
        huddleSafeApiCall {
            prApiHelper.getGithubPrs(page)
        }

}