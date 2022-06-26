package com.shivam.prs.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shivam.base.ResultWrapper
import com.shivam.prs.api.PrApiHelper
import com.shivam.prs.models.PrResponseModel
import com.shivam.prs.models.PullRequest
import com.shivam.prs.repository.PrRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class PrDataSource(val prRepository: PrRepository) :
    PagingSource<Int, PullRequest>() {

    override fun getRefreshKey(state: PagingState<Int, PullRequest>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PullRequest> {
        return try {
            val nextPage = params.key ?: 1
            val prRes = prRepository.getPr(page = nextPage)
            when (prRes) {
                is ResultWrapper.Success -> {
                    var prList = prRes.value
                    LoadResult.Page(
                        data = prList,
                        prevKey = if (nextPage == 1) null else nextPage - 1,
                        nextKey = if (prList.isEmpty()) null else nextPage.plus(1)
                    )
                }
                is ResultWrapper.Failure -> {
                    return LoadResult.Error(Throwable("Network Error"))
                }
                else -> {
                    return LoadResult.Error(Throwable("IO Error"))
                }
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}