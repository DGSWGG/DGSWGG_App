package kr.hs.dgsw.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.entity.summoner.Summoner

interface SummonerRepository {
    fun postRefreshSummonerInfo(
        grade: Int,
        klass: Int,
        number: Int,
        name: String,
        summonerName: String
    ): Flow<String>

    fun getSummonerByName(summonerName: String): Flow<Summoner>
}