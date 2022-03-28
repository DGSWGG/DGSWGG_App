package kr.hs.dgsw.data.datasource.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.domain.entity.Search
import javax.inject.Inject

class SearchPagingSource @Inject constructor(
    private val cache: SearchCache
): PagingSource<Int, Search>() {
    override fun getRefreshKey(state: PagingState<Int, Search>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPos)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Search> {
        val position = params.key ?: 0
        val loadData = cache.getAll(params.loadSize, position).map {
            it.toEntity()
        }

        return LoadResult.Page(
            data = loadData,
            prevKey = if (position == 0) null else position - 1,
            nextKey = if (position == loadData.size) null else position + 1
        )
    }
}