package kr.hs.dgsw.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.entity.Search

interface SearchRepository {
    fun getAll(size: Int): Flow<PagingData<Search>>
    suspend fun insertSearch(search: Search)
    suspend fun deleteAllSearch()
    suspend fun deleteSearch(id: Long)
}