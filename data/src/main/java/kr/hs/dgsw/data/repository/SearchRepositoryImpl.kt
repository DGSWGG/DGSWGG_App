package kr.hs.dgsw.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.data.datasource.search.SearchDataSource
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
): SearchRepository {
    override fun getAll(size: Int): Flow<PagingData<Search>> {
        return searchDataSource.getAll(size)
    }

    override suspend fun insertSearch(search: Search) {
        searchDataSource.insertSearch(search)
    }

    override suspend fun deleteAllSearch() {
        searchDataSource.deleteAllSearch()
    }

    override suspend fun deleteSearch(id: Long) {
        searchDataSource.deleteSearch(id)
    }
}