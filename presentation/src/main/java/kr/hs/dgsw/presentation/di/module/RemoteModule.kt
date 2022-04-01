package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.remote.SummonerRemote
import kr.hs.dgsw.data.network.service.SummonerService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideSummonerRemote(summonerService: SummonerService): SummonerRemote {
        return SummonerRemote(summonerService)
    }
}