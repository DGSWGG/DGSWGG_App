package kr.hs.dgsw.data.datasource.search

import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.mapper.toData
import kr.hs.dgsw.domain.entity.Search
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val cache: SearchCache
) {
    suspend fun insertSearch(search: Search) {
        cache.insertSearch(search.toData())
    }

    suspend fun deleteSearch(id: Long) {
        cache.deleteSearch(id)
    }
}