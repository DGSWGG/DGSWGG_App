package kr.hs.dgsw.domain.usecase.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Inject

class GetAllSearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
): ParamsBaseUseCase<GetAllSearchUseCase.Params, Flow<PagingData<Search>>> {
    data class Params(val size: Int)

    override fun buildParamsUseCase(params: Params): Flow<PagingData<Search>> {
        return searchRepository.getAll(params.size)
    }
}