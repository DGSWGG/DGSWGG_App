package kr.hs.dgsw.domain.usecase.summoner

import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.repository.SummonerRepository
import javax.inject.Inject

class PostRefreshSummonerInfoUseCase @Inject constructor(
    private val summonerRepository: SummonerRepository
): ParamsBaseUseCase<PostRefreshSummonerInfoUseCase.Params, Flow<String>> {
    class Params(
        val grade: Int,
        val klass: Int,
        val number: Int,
        val name: String,
        val summonerName: String
    )

    override fun buildParamsUseCase(params: Params): Flow<String> {
        return summonerRepository.postRefreshSummonerInfo(
            params.grade,
            params.klass,
            params.number,
            params.name,
            params.summonerName
        )
    }
}