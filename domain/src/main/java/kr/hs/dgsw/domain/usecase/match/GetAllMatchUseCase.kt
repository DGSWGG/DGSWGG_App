package kr.hs.dgsw.domain.usecase.match

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.repository.MatchRepository
import javax.inject.Inject

class GetAllMatchUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) : ParamsBaseUseCase<GetAllMatchUseCase.Params, Flow<PagingData<Search>>> {
    data class Params(val size: Int, val summonerId: String)

    override fun buildParamsUseCase(params: Params): Flow<PagingData<Search>> {
        return matchRepository.getAllMatch(params.size, params.summonerId)
    }
}