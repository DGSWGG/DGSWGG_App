package kr.hs.dgsw.data.database.cache

import kr.hs.dgsw.data.database.base.BaseCache
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.entity.SearchData
import javax.inject.Inject

class SearchCache @Inject constructor(
    override val dao: SearchDao
) : BaseCache<SearchDao> {
    suspend fun getAll(
        size: Int,
        page: Int
    ): List<SearchData> {
        return dao.getAll(size, page)
    }

    suspend fun insertSearch(searchData: SearchData) {
        return dao.insertSearch(searchData)
    }

    suspend fun deleteAllSearch() {
        return dao.deleteAllSearch()
    }

    suspend fun deleteSearch(id: Long) {
        return dao.deleteSearch(id)
    }
}