package kr.hs.dgsw.presentation.di.module.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.MatchRepository
import kr.hs.dgsw.domain.usecase.match.GetAllMatchUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchUseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllMatchUseCase(matchRepository: MatchRepository): GetAllMatchUseCase {
        return GetAllMatchUseCase(matchRepository)
    }
}