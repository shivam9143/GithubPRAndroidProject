package com.shivam.prs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shivam.prs.Paging.PrDataSource
import com.shivam.prs.api.PrApiHelper
import com.shivam.prs.models.PrResponseModel
import com.shivam.prs.models.PullRequest
import com.shivam.prs.repository.PrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class PrViewModel @Inject constructor(
    val prRepository: PrRepository
) : ViewModel() {

    private val TAG = "PrViewModel"

    val prList: Flow<PagingData<PullRequest>> = Pager(PagingConfig(pageSize = 6)) {
        PrDataSource(prRepository)
    }.flow.cachedIn(viewModelScope)

}

